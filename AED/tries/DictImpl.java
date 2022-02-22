package aed.tries;



import java.util.Arrays;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.tree.GeneralTree;
import es.upm.aedlib.tree.LinkedGeneralTree;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.positionlist.NodePositionList;


public class DictImpl implements Dictionary {
  // A boolean because we need to know if a word ends in a node or not
  GeneralTree<Pair<Character,Boolean>> tree;

  public DictImpl() {
    tree = new LinkedGeneralTree<>();
    tree.addRoot(new Pair<Character,Boolean>(null,false));
  }

//FUNCIONES EXTRAS
  
/*-----------------------------------------------------------------------------------------------------------------------------*/
  
// IS WORD  : Esta funcion es una funcion a la que llamamos varia veces para comprobar que la palabra ni es nula ni esta vacia
  
  
  private void isWord (String word) {
	  if(word == null || word.length() == 0) {
		  throw new IllegalArgumentException();
	  }
  }
  
/*-----------------------------------------------------------------------------------------------------------------------------*/  
  
// FIND POSITION
  
  
  private Position<Pair<Character,Boolean>> findPos(String Pos){
	  int i  = 0;//Creamos un contador, donde almacenamos el caracter que marca i
	  Position<Pair<Character,Boolean>> res = null; // Creamos el resultado que sera lo que nos devuelva
	  return findPos(Pos,tree.root(),i,res);//llamamos a otra funcion que nos dara un nodo y introducira el contador y el resultado
  }
  
 
  private Position<Pair<Character, Boolean>> findPos(String pos, Position<Pair<Character, Boolean>> node, int i, Position<Pair<Character,Boolean>> res) {
	  Position<Pair<Character,Boolean>> posi =  searchChildLabelledBy(pos.charAt(i),node);//Vamos cogiendo el nodo que tiene el caracter marcado por la string y el contador
	  if(posi!= null) {//Si hay un nodo con ese caracter:
		  if(i==pos.length()-1) {//si es el ultimo caracter :
			  return res=posi;//guarda la posicion en res y lo devuelve, esto hace que pare el bucle
		  }
		  i++;//anade 1 al contador
		  res = findPos(pos,posi,i,res);//llama recursivamente a la funcion
	  }
	  
	  
	  
	return res;
}
  
/*-----------------------------------------------------------------------------------------------------------------------------*/
  
//SEARCH CHILD LABELLED BY
  
private Position<Pair<Character,Boolean>> searchChildLabelledBy(char ch, Position<Pair<Character,Boolean>> pos){
	Position<Pair<Character,Boolean>> res = null;//inicica un resultado
	for(Position<Pair<Character,Boolean>> hijo : tree.children(pos)) {//bucle para bucar por todo los hijos del arbol empezando desde el nodo pos
		  if(hijo.element().getLeft().equals(ch)) {//si es igual el caracter dado con el del hijo que marca el bucle:
			  return res = hijo;//resultado = hijo con el mismo caracter y lo devuelve como resultado
		  }
	  }
	return res;// devuelve el resultado si es null
  }

/*-----------------------------------------------------------------------------------------------------------------------------*/

//ADD CHILD ALPHABETICALLY 

  private Position<Pair<Character,Boolean>> addChildAlphabetically(Pair<Character,Boolean> pair, Position<Pair<Character,Boolean>> pos){
	  Position<Pair<Character,Boolean>> res = null;//inicia resultado
	  Character car = pair.getLeft(); // guarda el valor del caracater en una variable
	  if(!tree.isExternal(pos)) {//si el nodo es externo significa que no tiene hijos con lo que lo anade como hijo y devuelve
		  
		  for(Position<Pair<Character,Boolean>> hijo : tree.children(pos)) {// recorre todo los hijos de pos
			  if (car.equals( hijo.element().getLeft())) { // si el caracter es igual que el caracter dado, actualiza el pair y devuelve el hijo
				  tree.set(hijo, pair);
				  return res = hijo;
				  
			  }
			  if(car < hijo.element().getLeft()) {// si es menor de lo anade detras del hijo en el que esta el bucle
				  return res = tree.insertSiblingBefore(hijo, pair);

			  }
		  
		  }
		  	 if(res == null) {// si no ha cumplido ninguna de las dos significa que esta al final con lo que lo anade al final;
		  		  res =tree.addChildLast(pos, pair); 
		  }
	  }
	  else {
		  return res = tree.addChildFirst(pos, pair);
	
	  }
	  
	  return res;
  }
  
/*-----------------------------------------------------------------------------------------------------------------------------*/  
/*-----------------------------------------------------------------------------------------------------------------------------*/

//FUNCIONES OBLIGATORIAS  
  
//ADD

  public void add(String word) { 
	  isWord(word);
	  int i = 0;
	  add(word,tree.root(),i);
  }
  
  
  
  private void add(String word, Position<Pair<Character, Boolean>> node, int  i) {
	 
	if(i == word.length()-1) {// si llega al final llama a addChildAlphabetically con un nuevo par con su ultimo valor siendo true
		Pair<Character,Boolean> res = new Pair<>(word.charAt(i),true);
		addChildAlphabetically(res,node);
		
	}
	else {	// si no es final
	Position<Pair<Character,Boolean>> aux = searchChildLabelledBy(word.charAt(i),node);//busca el child con el caracter de la palabra senalado por i 
	if(aux == null) {// si aux es igual a null (Significa que no hay ningun par con ese elemento) crea un par falso y lo anade
		Pair<Character,Boolean> resu = new Pair<>(word.charAt(i),false);
		aux = addChildAlphabetically(resu,node);
		
		
	}
	i++;
	add(word,aux,i);// llamada recursivamente si no es final
	}

  }
  
/*-----------------------------------------------------------------------------------------------------------------------------*/
  
//DELETE  
  
  public void delete(String word) {
	  isWord(word);
	  
	  if(isIncluded(word)) {// si existe la palabra en el arbol
		  Position<Pair<Character,Boolean>> pos = findPos(word);//Busca la posicion de la palabra
		  tree.set(pos, new Pair<Character, Boolean>(pos.element().getLeft(),false));// cambia su boolean a falso
		 
	  }
  }
  
  
/*-----------------------------------------------------------------------------------------------------------------------------*/ 
  
//IS INCLUDED 
  
  public boolean isIncluded(String word) {
	  
	  isWord(word);
	  Position<Pair<Character, Boolean>> res = findPos(word);//Busca la posicion de la palabra 
	  return res != null && res.element().getRight() == true; // si la palabra buscada no es null y su booleano es true devuelve true
	}
  
  
/*-----------------------------------------------------------------------------------------------------------------------------*/
	
//WORD BEGGINING WITH PREFIX	
  
  public PositionList<String> wordsBeginningWithPrefix(String prefix) { 
	  PositionList<String> res  = new NodePositionList<>();// crea la PositionList resultado
	  Position<Pair<Character,Boolean>> node = null;// crea el nodo donde empezara la cadena segun prefix
	 
	  if(prefix.length()==0) {// si prefix esta vacio marca el nodo inicio en la raiz
		   node = tree.root();
	  }
	  else {// si no lo marca en la posicion en la que se encuentre el prefijo
		  node = findPos(prefix);
		  if(node.element().getRight()==true) {// si la el elemento de la pos  ==  true lo anade a la lista
		  res.addLast(prefix);
		  }
	  }
	  
	  return wordsBeginningWithPrefix(prefix,node,res); // llama a otra funcion anadiendo el la positionlist y el nodo donde empieza las variantes del con el prefijo 
	  }

  
private PositionList<String> wordsBeginningWithPrefix(String prefix, Position<Pair<Character, Boolean>> node,
		PositionList<String> res) {
		for(Position<Pair<Character,Boolean>> hijo : tree.children(node)) {//busca por todos los hijos desde node
			if(hijo.element().getRight()==true) {// si el booleano del hijo es true lo anade
				res.addLast(prefix+hijo.element().getLeft());
			
			}
			res = wordsBeginningWithPrefix(prefix+hijo.element().getLeft(),hijo,res);// y llama recursivamente a la funcion con el hijo
		}
		
	return res;
}
}



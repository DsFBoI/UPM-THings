public class CancionTest {
    public static void main(String[] args) {
        Cancion c1 = new Cancion("Golden","Harry Styles","Fine Line",209,"Pop");
        System.out.println(" | "+ c1.Titulo +" | "+ c1.artist +" | "+ c1.Album +" | "+ c1.Type +" | "+ c1.Duracionsec + " secs | ");
        Cancion c2 = new Cancion("Juicy", "Notorious B.I.G.", "Ready To Die",303,"Hip-Hop");
        System.out.println(" | "+ c2.Titulo +" | "+ c2.artist +" | "+ c2.Album +" | "+ c2.Type +" | "+ c2.Duracionsec + " secs | ");
        Cancion c3 = new Cancion("Say So", "Doja Cat", "Hot Pink",238,"Pop");
        System.out.println(" | "+ c3.Titulo +" | "+ c3.artist +" | "+ c3.Album +" | "+ c3.Type +" | "+ c3.Duracionsec + " secs | ");


    }
    
}

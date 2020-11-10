import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

    	String folderPath = "D:\\ESTUDO\\EstudoJava\\JavaCompleto2020\\FolderWithFile";
    	String subdir = folderPath + "\\subDirTeste";
    	
    	String arquivo1 = "\\teste1.txt";
    	String arquivo2 = "\\teste2.txt";
		String arquivo3 = "\\teste3.txt";
		
    	// Folder path
    	File f1 = new File(folderPath);
    	
        try(
        	BufferedWriter bw1= new BufferedWriter(new FileWriter(folderPath + arquivo1));
        	BufferedWriter bw2 = new BufferedWriter(new FileWriter(folderPath + arquivo2))) {
        	bw1.write("Escrevendo no primeiro arquivo");
			bw2.write("Escrevendo no segundo arquivo.");
			
        	

			// listar diretorios
			File[] folders = f1.listFiles(File::isDirectory); // reference methods sintaxe ::
			System.out.println("FOLDERS:");
			for (File folder : folders) {// listagem de diretorios
			    System.out.println("Folders: " + folder.getName());
			}

			// listagem de arquivos
			File[] files = f1.listFiles(File::isFile);
			System.out.println("FILES:");
			for (File file : files) {
			    System.out.println("File: " + file.getName());
			}

			boolean success = new File(subdir).mkdir(); // criar novo diretorio
			System.out.println("Diretorio criado: " + success);
			
			try(BufferedWriter bw3 = new BufferedWriter(new FileWriter(subdir + arquivo3))){
				bw3.write("Escrevendo no arquivo do subdiretorio");
			}
			
		} catch (IOException e) {
			System.out.println("ERROR I/O" + e.getMessage());
		}
    }// main
}// class

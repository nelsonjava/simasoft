package co.simasoft.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import de.idyl.winzipaes.AesZipFileEncrypter;
import de.idyl.winzipaes.impl.AESEncrypterBC;

public class PZip {

	/**
	 * This method is used to zip or compress a directory to create a zip file.
	 * @param directory of type String indicating the source directory to be zipped
	 * @param zos of type {@link ZipOutputStream}
	 * @param path of type String indicating the path
	 * @throws IOException
	 */
	private static void compressDir(String directory, 
									ZipOutputStream zos, 
									String path) throws IOException {
		File zipDir = new File(directory);
		String[] dirList = zipDir.list();
		byte[] readBuffer = new byte[2156];
		int bytesIn = 0;

		for (int i = 0; i < dirList.length; i++) {
			File f = new File(zipDir, dirList[i]);
			
			if (f.isDirectory()) {
				String filePath = f.getPath();
				compressDir(filePath, zos, path + f.getName() + "/");
				continue;
			}

			FileInputStream fis = new FileInputStream(f);
		
			try {
				ZipEntry anEntry = new ZipEntry(path + f.getName());
				zos.putNextEntry(anEntry);
				bytesIn = fis.read(readBuffer);

				while (bytesIn != -1) {
					zos.write(readBuffer, 0, bytesIn);
					bytesIn = fis.read(readBuffer);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {				
				fis.close();
			}
		} // end : for

	} // end : compressDir Method	

	/**
	 * This method is used to zip a directory
	 * @param dirName of type String indicating the path of the directory to be zipped
	 * @param zipFileName of type String indicating the file name for the zip file
	 */
	public static void zipDir(String dirName, String zipFileName) {

		if (zipFileName == null) {
			File tempFile = new File(dirName);
			zipFileName = tempFile.getAbsoluteFile().getParent() + File.separator+tempFile.getName() + ".zip";
		}

		try {
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName));
			compressDir(dirName, zos, new File(dirName).getName() + File.separator);
			zos.close();
		} catch(NullPointerException npEx) {		
			npEx.printStackTrace();
		} catch (FileNotFoundException fnfEx) {		
			fnfEx.printStackTrace();
		} catch(IOException ioEx) {		
			ioEx.printStackTrace();
		}

	} // end : zipDir Method	

	/**
	 * This method is used to create a password protected zip file.
	 * @param dirName of type String indicating the name of the directory to be zipped
	 * @param zipFileName of type String indicating the name of the zip file to be created
	 * @param password of type String indicating the password
	 */
	public static void zipDirWithPassword(String dirName, 
										  String zipFileName, 
										  String password) {
		if (zipFileName == null) {	
			File tempFile = new File(dirName);
			zipFileName = tempFile.getAbsoluteFile().getParent() + File.separator+tempFile.getName() + ".zip";
		}

		zipDir(dirName, zipFileName);
		String tempZipFileName = new File(dirName).getAbsoluteFile().getParent() + File.separator + "tempencrypted.zip";

		try {		
			AesZipFileEncrypter enc = new AesZipFileEncrypter(tempZipFileName, new AESEncrypterBC());			
			enc.add(new File(zipFileName), password);				
			enc.close();

			String zipFileWithPassword = zipFileName.split("\\.")[0] + "-ok.zip";

			new File(zipFileName).delete();			
			new File(tempZipFileName).renameTo(new File(zipFileWithPassword));	
		} catch (IOException ioEx) {		
			ioEx.printStackTrace();
		}
	} // end : zipDirWithPassword Method   

}
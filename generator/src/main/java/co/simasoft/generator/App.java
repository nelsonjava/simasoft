package co.simasoft.generator;

import co.simasoft.utils.*;
import co.simasoft.generator.utils.*;

import java.io.*;

public class App{

    public static void main( String[] args ) throws IOException {

        String artifactId = Ui.artifactId();
        String groupId = Ui.groupId();
        int typeApp = Ui.typeApp();

        switch (typeApp) {
            case 1:  System.out.println("jar " + typeApp);
                     break;

            case 2:  System.out.println("War " + typeApp);
                     break;

            case 3:  System.out.println("typeApp " + typeApp);
                     TypeApp.Jar(artifactId,"com.simavirtual");
                     break;

            default: System.out.println("!!Error!! Numero incorrecto: " + typeApp);
                     break;
        }

    }
}

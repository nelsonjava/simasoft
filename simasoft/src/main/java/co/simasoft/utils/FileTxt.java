package co.simasoft.utils;

public class FileTxt {

    protected String source = "";
    private StringBuilder stringBuilder;

    public FileTxt() {
        this.stringBuilder = new StringBuilder();
    }

    public String getSource() {
        this.source = stringBuilder.toString();
        return this.source;
    }

    public void line(String linea) {
        stringBuilder.append(linea);
        stringBuilder.append("\n");
    }

    public void line(String linea, int spaces) {

        String error = "";

        if(spaces < 0) {
            error = "sys.error : line : Parametro negativo " + spaces;
            System.out.println(error);
        }
        else {
            line(Utils.spaces(spaces) + linea);
        }

    }

    public StringBuilder getStringBuilder() {
        return this.stringBuilder;
    }

} // Fin de la Clase

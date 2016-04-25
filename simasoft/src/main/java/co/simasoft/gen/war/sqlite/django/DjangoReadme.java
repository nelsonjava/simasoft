package co.simasoft.gen.war.sqlite.django;

import co.simasoft.utils.*;

public class DjangoReadme extends FileTxt {

public DjangoReadme(String artifactId) {

line("# MARKDOWN\n");

line("http://dillinger.io/\n");
line("https://github.com/django\n");

line("# Configurar Django para el primer proyecto");

line("## Instalar Virtual Env de forma Global");

line("Virtualenv nos permite encapsular versiones de librerias, herramientas y utilidades de Django, permitiendo tener un entorno de desarrollo aislado y mas controlado.\n");

line("```sh");
line("pip install virtualenv");
line("```");

line("## Instalar Django de forma Global");

line("```sh");
line("pip install django");
line("```");

line("La versión 1.9 es la mas estable");

line("# Configurar VirtualEnv para el proyecto "+artifactId);

line("```sh");
line("virtualenv "+artifactId);
line("pip install django");
line("django-admin.py startproyect"+artifactId);
line("python manage.py runserver");
line("python manage.py migrate");

line("# Creación de la aplicación "+artifactId);

line("```sh");
line("python manage.py startapp "+artifactId);
line("Creación del modelo en:"+artifactId+"\\models.py");
line("modelos generados en docs.sqlite.django."+artifactId+".models");
line("python manage.py check - verifica errores");
line("instalar la aplicación en"+artifactId+" settings.py");
line("INSTALLED_APPS = [");
line("    '"+artifactId+".apps."+artifactId+"Config',");
line("    '.',");
line("    '.',");
line("    '.',");
line("]");
line("python manage.py makemigrations");
line("python manage.py createsuperuser - Crea el usuario para la consola de la administración");
line("");
line("instalar la aplicación en"+artifactId+" admin.py");
line("admin.site.register("+artifactId+")");
line("@admin.register(Task)");
line("class AdminTask(admin.AdminModel)");
line("    list_display = ('id','name',)");
line("    list_filter = ('name',)");





line("```");

line("# Activar y Desactivar el proyecto");

line("source "+artifactId+"/bin/activate");
line("desactive");

line("# Comprobar la instalación");

line("```sh");
line("source "+artifactId+"/bin/activate");
line("pip freeze");
line("pip freeze > requirements.txt");
line("pip install -r requirements.txt");
line("```");


line("# Intalación de la aplicaciópn en "+artifactId+" settings.py");

line("INSTALLED_APPS = [");
line("    '"+artifactId+".apps."+artifactId+"Config',");
line("    '.',");
line("    '.',");
line("    '.',");
line("]");



    } // Generar

} // Fin de clase
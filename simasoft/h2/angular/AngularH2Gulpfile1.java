package co.simasoft.gen.war.h2.angular;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class AngularH2Gulpfile1 extends FileTxt {

  public AngularH2Gulpfile1(String artifactId) {

line("// File: Gulpfile.js");
line("'use strict';");

line("var gulp      = require('gulp'),");
line("    connect   = require('gulp-connect'),");
line("    stylus    = require('gulp-stylus'),");
line("    nib       = require('nib'),");
line("    jshint    = require('gulp-jshint'),");
line("    stylish   = require('jshint-stylish'),");
line("    inject    = require('gulp-inject'),");
line("    wiredep   = require('wiredep').stream,");
line("    gulpif    = require('gulp-if'),");
line("    minifyCss = require('gulp-minify-css'),");
line("    useref    = require('gulp-useref'),");
line("    uglify    = require('gulp-uglify'),");
line("    uncss     = require('gulp-uncss'),");
line("    angularFilesort = require('gulp-angular-filesort'),");
line("    templateCache = require('gulp-angular-templatecache'),");
line("    historyApiFallback = require('connect-history-api-fallback');\n");

line("// Servidor web de desarrollo");
line("gulp.task('server', function() {");
line("  connect.server({");
line("    root: './app',");
line("    hostname: '0.0.0.0',");
line("    port: 8080,");
line("    livereload: true,");
line("    middleware: function(connect, opt) {");
line("      return [ historyApiFallback ];");
line("    }");
line("  });");
line("});\n");

line("// Servidor web para probar el entorno de producción");
line("gulp.task('server-dist', function() {");
line("  connect.server({");
line("    root: './dist',");
line("    hostname: '0.0.0.0',");
line("    port: 8080,");
line("    livereload: true,");
line("    middleware: function(connect, opt) {");
line("      return [ historyApiFallback ];");
line("    }");
line("  });");
line("});\n");

line("// Busca errores en el JS y nos los muestra por pantalla");
line("gulp.task('jshint', function() {");
line("  return gulp.src('./app/scripts/**/*.js')");
line("    .pipe(jshint('.jshintrc'))");
line("    .pipe(jshint.reporter('jshint-stylish'))");
line("    .pipe(jshint.reporter('fail'));");
line("});\n");

line("// Preprocesa archivos Stylus a CSS y recarga los cambios");
line("gulp.task('css', function() {");
line("  gulp.src('./app/stylesheets/main.styl')");
line("    .pipe(stylus({ use: nib() }))");
line("    .pipe(gulp.dest('./app/stylesheets'))");
line("    .pipe(connect.reload());");
line("});\n");

line("// Recarga el navegador cuando hay cambios en el HTML");
line("gulp.task('html', function() {");
line("  gulp.src('./app/**/*.html')");
line("    .pipe(connect.reload());");
line("});\n");

line("// Busca en las carpetas de estilos y javascript los archivos");
line("// para inyectarlos en el index.html");
line("gulp.task('inject', function() {");
line("  return gulp.src('index.html', {cwd: './app'})");
line("    .pipe(inject(");
line("      gulp.src(['./app/scripts/**/*.js']).pipe(angularFilesort()), {");
line("      read: false,");
line("      ignorePath: '/app'");
line("    }))");
line("    .pipe(inject(");
line("      gulp.src(['./app/stylesheets/**/*.css']), {");
line("        read: false,");
line("        ignorePath: '/app'");
line("      }");
line("    ))");
line("    .pipe(gulp.dest('./app'));");
line("});\n");

line("// Inyecta las librerias que instalemos vÃ­a Bower");
line("gulp.task('wiredep', function () {");
line("  gulp.src('./app/index.html')");
line("    .pipe(wiredep({");
line("      directory: './app/lib'");
line("    }))");
line("    .pipe(gulp.dest('./app'));");
line("});\n");

line("// Compila las plantillas HTML parciales a JavaScript");
line("// para ser inyectadas por AngularJS y minificar el cÃ³digo");
line("gulp.task('templates', function() {");
line("  gulp.src('./app/views/**/*.tpl.html')");
line("    .pipe(templateCache({");
line("      root: 'views/',");
line("      module: 'blog.templates',");
line("      standalone: true");
line("    }))");
line("    .pipe(gulp.dest('./app/scripts'));");
line("});\n");

line("// Comprime los archivos CSS y JS enlazados en el index.html");
line("// y los minifica.");
line("gulp.task('compress', function() {");
line("  gulp.src('./app/index.html')");
line("    .pipe(useref.assets())");
line("    .pipe(gulpif('*.js', uglify({mangle: false })))");
line("    .pipe(gulpif('*.css', minifyCss()))");
line("    .pipe(gulp.dest('./dist'));");
line("});\n");

line("// Elimina el CSS que no es utilizado para reducir el peso del archivo");
line("gulp.task('uncss', function() {");
line("  gulp.src('./dist/css/style.min.css')");
line("    .pipe(uncss({");
line("      html: ['./app/index.html', './app/views/post-list.tpl.html', './app/views/post-detail.tpl.html']");
line("    }))");
line("    .pipe(gulp.dest('./dist/css'));");
line("});\n");

line("// Copia el contenido de los estÃ¡ticos e index.html al directorio");
line("// de producció sin tags de comentarios");
line("gulp.task('copy', function() {");
line("  gulp.src('./app/index.html')");
line("    .pipe(useref())");
line("    .pipe(gulp.dest('./dist'));");
line("  gulp.src('./app/lib/fontawesome/fonts/**')");
line("    .pipe(gulp.dest('./dist/fonts'));");
line("});\n");

line("// Vigila cambios que se produzcan en el código");
line("// y lanza las tareas relacionadas");
line("gulp.task('watch', function() {");
line("  gulp.watch(['./app/**/*.html'], ['html', 'templates']);");
line("  gulp.watch(['./app/stylesheets/**/*.styl'], ['css', 'inject']);");
line("  gulp.watch(['./app/scripts/**/*.js', './Gulpfile.js'], ['jshint', 'inject']);");
line("  gulp.watch(['./bower.json'], ['wiredep']);");
line("});\n");

line("gulp.task('default', ['server', 'templates', 'inject', 'wiredep', 'watch']);");
line("gulp.task('build', ['templates', 'compress', 'copy', 'uncss']);");

  } // Generar

} // Fin de clase
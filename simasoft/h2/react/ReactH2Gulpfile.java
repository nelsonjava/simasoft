package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2Gulpfile extends FileTxt {

  public ReactH2Gulpfile(String artifactId) {

line("var gulp = require('gulp');");
line("var webserver = require('gulp-webserver');");
line("var stylus = require('gulp-stylus');");
line("var nib = require('nib');");
line("var minifyCSS = require('gulp-minify-css');\n");

line("var config = {");
line("  styles: {");
line("    main: './src/styles/main.styl',");
line("    watch: './src/styles/**/*.styl',");
line("    output: './build/css'");
line("  },");
line("  html: {");
line("    watch: './build/*.html'");
line("  }");
line("}\n");

line("gulp.task('server', function() {");
line("  gulp.src('./build')");
line("    .pipe(webserver({");
line("      host: '0.0.0.0',");
line("      port: 8080,");
line("      livereload: true");
line("    }));");
line("});\n");

line("gulp.task('build:css', function() {");
line("  gulp.src(config.styles.main)");
line("    .pipe(stylus({");
line("      use: nib(),");
line("      'include css': true");
line("    }))");
line("    .pipe(minifyCSS())");
line("    .pipe(gulp.dest(config.styles.output));");
line("});\n");

line("gulp.task('watch', function() {");
line("  gulp.watch(config.styles.watch, ['build:css']);");
line("  gulp.watch(config.html.watch, ['build']);");
line("})\n");

line("gulp.task('build', ['build:css'])\n");

line("gulp.task('default', ['server', 'watch', 'build']);\n");

  } // Generar

} // Fin de clase
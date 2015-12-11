package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2Css extends FileTxt {

  public ReactH2Css(String artifactId) {

line("<!DOCTYPE html>");

line("/* http://meyerweb.com/eric/tools/css/reset/");
line("   v2.0 | 20110126");
line("   License: none (public domain)");
line("*/\n");

line("html, body, div, span, applet, object, iframe,");
line("h1, h2, h3, h4, h5, h6, p, blockquote, pre,");
line("a, abbr, acronym, address, big, cite, code,");
line("del, dfn, em, img, ins, kbd, q, s, samp,");
line("small, strike, strong, sub, sup, tt, var,");
line("b, u, i, center,");
line("dl, dt, dd, ol, ul, li,");
line("fieldset, form, label, legend,");
line("table, caption, tbody, tfoot, thead, tr, th, td,");
line("article, aside, canvas, details, embed,");
line("figure, figcaption, footer, header, hgroup,");
line("menu, nav, output, ruby, section, summary,");
line("time, mark, audio, video {");
line("  margin: 0;");
line("  padding: 0;");
line("  border: 0;");
line("  font-size: 100%;");
line("  font: inherit;");
line("  vertical-align: baseline;");
line("}");
line("/* HTML5 display-role reset for older browsers */");
line("article, aside, details, figcaption, figure,");
line("footer, header, hgroup, menu, nav, section {");
line("  display: block;");
line("}");
line("body {");
line("  line-height: 1;");
line("}");
line("ol, ul {");
line("  list-style: none;");
line("}");
line("blockquote, q {");
line("  quotes: none;");
line("}");
line("blockquote:before, blockquote:after,");
line("q:before, q:after {");
line("  content: '';");
line("  content: none;");
line("}");
line("table {");
line("  border-collapse: collapse;");
line("  border-spacing: 0;");
line("}\n");

line(".pokeapp {");
line("  width: 100%;");
line("  overflow: hidden;");
line("}\n");

line(".poketable {");
line("  width: 30%;");
line("  float: left;");
line("  height: 100%;");
line("  overflow: scroll;");
line("}\n");

line(".pokerow {");
line("  background-color: lightblue;");
line("  border: 1px solid black;");
line("  width: 100%;");
line("  height: 80px;");
line("  line-height: 80px;");
line("}\n");

line(".avatar-container {");
line("  width: 120px;");
line("  display: inline-block;");
line("  text-align: center;");
line("}\n");

line(".avatar {");
line("  vertical-align: middle;");
line("  max-height: 75px;");
line("  max-width: 100px;");
line("}\n");

line(".pokechat {");
line("  width: 70%;");
line("  float: right;");
line("  height: 100%;");
line("  overflow: scroll;");
line("}\n");

line(".message-animation-enter {");
line("  opacity: 0;");
line("  transition: opacity .5s ease-in;");
line("}\n");

line(".message-animation-enter.message-animation-enter-active {");
line("  opacity: 1;");
line("}\n");


  } // Constructor

} // ReactH2Build
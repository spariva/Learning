<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  

  <xsl:template match="/">
    <html>
      <head>
        <title>Tabla de Productos</title>
        <link rel="stylesheet" type="text/css" href="contact.css" />
        <style>
          table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
          }
        </style>
      </head>
      <body>
        <h1>Productos</h1>
        <div class="container">
        <table>
          <tr>
            <th>Nombre</th>
            <th>Código</th>
            <th>Precio</th>
          </tr>
          <xsl:for-each select="productos/producto">
            <tr>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="código"/></td>
              <td><xsl:value-of select="precio"/></td>
            </tr>
          </xsl:for-each>
        </table>
        </div>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>

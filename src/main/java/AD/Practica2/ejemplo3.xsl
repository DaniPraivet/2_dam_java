<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Lista de Personajes de Brawlhalla</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Ataque</th>
                            <th>Defensa</th>
                            <th>Destreza</th>
                            <th>Velocidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="personajes/personaje">
                            <tr>
                                <td><xsl:value-of select="nombre"/></td>
                                <td><xsl:value-of select="ataque"/></td>
                                <td><xsl:value-of select="defensa"/></td>
                                <td><xsl:value-of select="destreza"/></td>
                                <td><xsl:value-of select="velocidad"/></td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
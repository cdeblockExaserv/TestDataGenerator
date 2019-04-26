<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">Line1,Line2,ApartmentNumber,City,ZipCode,Country,AddressType,State
<xsl:for-each select="//Employee/Address">
<xsl:value-of select="concat(Line1,',',Line2,',',ApartmentNumber,',',City,',',ZipCode,',',Country,',',AddressType,',',State,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>

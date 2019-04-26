<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">CountryCode,Extension,PhoneNumber,IsPrimary
<xsl:for-each select="//Employee/Phone">
<xsl:value-of select="concat(CountryCode,',',Extension,',',PhoneNumber,',',IsPrimary,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>


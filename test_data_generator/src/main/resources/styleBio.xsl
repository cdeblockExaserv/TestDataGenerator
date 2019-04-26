﻿<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">EmployeeID,DateOfBirth,FirstName,MiddleName,LastName,Prefix,Suffix,Gender,DisplayName,BirthName,PreferedName,MaritalStatus,MaritalStatusSince,Nationality
<xsl:for-each select="//Employee/BiographicalData">
<xsl:value-of select="concat(EmployeeID,',',DateOfBirth,',',FirstName,',',MiddleName,',',LastName,',',Prefix,',',Suffix,',',Gender,',',DisplayName,',',BirthName,',',PreferedName,',',MaritalStatus,',',MaritalStatusSince,',',Nationality,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
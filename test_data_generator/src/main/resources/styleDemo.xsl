<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">Status,PersonID,FirstName,Nickname,MiddleName,LastName,Suffix,Title,Gender,Email,Manager,HR,Department,JobCode,Division,Location,Timezone,Hiredate,EmployeeID,BusinessPhone,Fax,AddressLine1,AddressLine2,City,State,ZIP,Country,MatrixManager,DefaultLocale,Proxy,SeatingChart,ReviewFrequency,LastReviewDate,CompanyExitDate,CustomRangeDate,CustomRangeNumeric,CustomFormat,CustomPicklist,CustomField5,CustomField6,CustomField7,CustomField8,CustomField9,CustomField10,PersonIDExternal,OnboardingID
<xsl:for-each select="//Employee/EmployeeData">
<xsl:value-of select="concat(Status,',',PersonID,',',FirstName,',',Nickname,',',MiddleName,',',LastName,',',Suffix,',',Title,',',Gender,',',Email,',',Manager,',',HR,',',Department,',',JobCode,',',Division,',',Location,',',Timezone,',',Hiredate,',',EmployeeID,',',BusinessPhone,',',Fax,',',AddressLine1,',',AddressLine2,',',City,',',State,',',ZIP,',',Country,',',MatrixManager,',',DefaultLocale,',',Proxy,',',SeatingChart,',',ReviewFrequency,',',LastReviewDate,',',CompanyExitDate,',',CustomRangeDate,',',CustomRangeNumeric,',',CustomFormat,',',CustomPicklist,',',CustomField5,',',CustomField6,',',CustomField7,',',CustomField8,',',CustomField9,',',CustomField10,',',PersonIDExternal,',',OnboardingID,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>

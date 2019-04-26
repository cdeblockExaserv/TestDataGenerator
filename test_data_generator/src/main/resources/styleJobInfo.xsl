<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">Incumbent,Position,PositionEntryDate,Company,BusinessUnit,Division,Department,Location,CostCenter,Timezone,Supervisor,JobClassification,PositionTitle,LocalJobTitle,PayGrade,IsRegular,StandardWeeklyHours,FTE,IsFulltime,EmployeeClass,ShiftCode,FSLAStatus,JobEntryDate,LeaveOfAbsenceStartDate,LeaveOfAbsenceReturnDate,LMSJobCodeID,EEOJobGroup,EEOCategory1,EEOCategory4,EEOCategory5,EEOCategory6
<xsl:for-each select="//Employee/JobInfo">
<xsl:value-of select="concat(Incumbent,',',Position,',',PositionEntryDate,',',Company,',',BusinessUnit,',',Division,',',Department,',',Location,',',CostCenter,',',Timezone,',',Supervisor,',',JobClassification,',',PositionTitle,',',LocalJobTitle,',',PayGrade,',',IsRegular,',',StandardWeeklyHours,',',FTE,',',IsFulltime,',',EmployeeClass,',',ShiftCode,',',FSLAStatus,',',JobEntryDate,',',LeaveOfAbsenceStartDate,',',LeaveOfAbsenceReturnDate,',',LMSJobCodeID,',',EEOJobGroup,',',EEOCategory1,',',EEOCategory4,',',EEOCategory5,',',EEOCategory6,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
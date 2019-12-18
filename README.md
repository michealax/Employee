# Employee

Personal/个人信息 <br>
	id 	name	 gender	 phone	 email 	live	<br>
  
birthday/生日	<br>
	id	 year	 month	 day	personalID	<br>
  
education/教育经历	<br>
	id  starTime endTime schoolName  professional/专业  personalID	<br>
  
work/工作经历	<br>
	id  startTime endTime company position/职位 department/部门   description/描述	personalID	<br>
  
objective/求职意向	<br>
	id  salary/期望薪资  place/地点  position/职位  type/工作类型，全职兼职    personalID	<br>
  
user/用户	<br>
	id name password isCompany informationId/是个人就是personalID企业就是companyID	<br>
  
company/公司	<br>
	id		name		address 	<br>
  
recruitment/招聘职位	<br>
	id companyID name salary education/学历 number/招聘人数 release/发布时间	<br>

deliver/已投递<br>
	id	personalID	recruitmentID/投递职位

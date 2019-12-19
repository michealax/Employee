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
	id		name		address 	description<br>
  
recruitment/招聘职位	<br>
	id companyID name salary education/学历 number/招聘人数 release/发布时间	<br>

deliver/已投递<br>
	id	personalID	recruitmentID/投递职位
	
city/中国城市<br>
	id  cityname	
	<br>
	pid/代表属于哪个id的下面，如广西的 id = 7，那么南宁的 pid = 7,桂林的 pid = 7...	
	<br>
	type/0代表中国，1代表省份，2代表市级，3代表县级<br>

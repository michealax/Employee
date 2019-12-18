# Employee

Personal/个人信息
	id 	name	 gender	 phone	 email 	live
  
birthday/生日
	id	 year	 month	 day	personalID
  
education/教育经历
	id  starTime endTime schoolName  professional/专业  personalID
  
work/工作经历
	id  startTime endTime company position/职位 department/部门   description/描述			personalID
  
objective/求职意向
	id  salary/期望薪资  place/地点  position/职位  type/工作类型，全职兼职    personalID
  
user/用户
	id name password isCompany informationId/是个人就是personalID企业就是companyID
  
company/公司
	id		name		address
  
recruitment/招聘职位
	id companyID name salary education/学历 number/招聘人数 release/发布时间

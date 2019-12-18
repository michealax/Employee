<template>

    <el-container>
        <el-header style="background: white;margin: 0 20px">
            <el-page-header @back="goBack" content="详情页面">
            </el-page-header>
        </el-header>


        <el-container style=" background-color: white;margin: 0 20px">

            <el-main>
                <el-container id="basicInfo">
                    <el-header>
                        <div class="header">基本信息</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main style="overflow: visible">
                        <el-card shadow="hover">
                            <div>
                                <div>姓名：{{person.name}} | {{person.gender === 0?'男':'女'}} |
                                    {{person.birthday}}
                                </div>
                                <div>邮箱：{{person.email}}</div>
                                <div>电话: {{person.phone}}</div>
                                <div>地址：{{person.live}}</div>
                            </div>
                        </el-card>
                    </el-main>
                </el-container>
                <el-divider></el-divider>

                <el-container id="objective" style="z-index: 998">
                    <el-header>
                        <div class="header">求职意向</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main style="overflow: visible">
                        <el-card shadow="hover">
                            <div>
                                <div>薪水：{{objective.salary}}</div>
                                <div>职位：{{objective.place}} | {{objective.position}}</div>
                                <div>类型：{{objective.type === 0?'兼职':'全职'}}</div>
                            </div>

                        </el-card>
                    </el-main>
                </el-container>
                <el-divider></el-divider>
                <el-container id="work">
                    <el-header>
                        <div class="header">工作经验</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main>
                        <el-card v-for="(item, key) in works" :key="key" shadow="hover" style="margin: 10px auto">
                            <div>
                                <div>时间：{{item.startTime}} 至 {{item.endTime}}</div>
                                <div>公司：{{item.company}}</div>
                                <div>部门: {{item.department}}</div>
                                <div>职位：{{item.position}}</div>
                                <div>描述：{{item.description}}</div>
                            </div>

                        </el-card>
                    </el-main>
                </el-container>

                <el-divider></el-divider>

                <el-container id="project">
                    <el-header>
                        <div class="header">项目经历</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main>
                        <el-card v-for="(item, key) in projects" :key="key" shadow="hover" style="margin: 10px auto;width: 500px">
                            <div>
                                <div>时间：{{item.startTime}} 至 {{item.endTime}}</div>
                                <div>项目名称：{{item.projectName}}</div>
                                <div>描述：{{item.description}}</div>
                            </div>

                        </el-card>
                    </el-main>
                </el-container>


                <el-divider></el-divider>
                <el-container id="education">
                    <el-header>
                        <div class="header">学历</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main>
                        <el-card v-for="(item, key) in educations" :key="key" shadow="hover" style="margin: 10px auto">
                            <div>
                                <div>时间：{{item.startTime}} 至 {{item.endTime}}</div>
                                <div>学校名称：{{item.schoolName}}</div>
                                <div>专业:{{item.professional}}</div>
                            </div>

                        </el-card>
                    </el-main>
                </el-container>
            </el-main>
        </el-container>
    </el-container>


</template>

<script>

    export default {
        name: "Resume",
        components: {},
        data() {
            return {
                id: -1,

                isNew: true,
                resume: {
                    resumeId: 2,
                    name: '我的简历1'
                },
                person: {
                    id: 2,
                    name: 'Shane',
                    gender: 0,
                    phone: '13908336520',
                    email: '163@123.com',
                    live: '上海, 浦东新区',
                    birthday: '2019-8-7'
                },
                objective: {
                    id: 2,
                    salary: 20000,
                    place: '计算机软件',
                    position: 'Java研发师',
                    type: 1,
                    resumeId: 2
                },
                works: [{
                    id: 1,
                    startTime: '2019-8-7',
                    endTime: '2019-10-12',
                    company: '腾讯',
                    position: 'Java研发',
                    department: '研发',
                    description: '团队项目',
                    resumeId: 2
                }, {
                    id: 2,
                    startTime: '2019-8-17',
                    endTime: '2019-10-12',
                    company: '腾讯1',
                    position: 'Java研发1',
                    department: '研发',
                    description: '团队项目',
                    resumeId: 2
                }],
                educations: [{
                    id: 1,
                    startTime: '2019-8-7',
                    endTime: '2019-8-9',
                    schoolName: '复旦大学',
                    professional: '软件工程',
                    resumeId: 2
                }],
                projects: [{
                    id: 1,
                    startTime: '2019-10-20',
                    endTime: '2019-10-31',
                    projectName: '团队项目',
                    description: '用户创建',
                    resumeId: 2
                },
                    {
                        id: 1,
                        startTime: '2019-10-20',
                        endTime: '2019-10-31',
                        projectName: '团队项目',
                        description: '人机交互项目',
                        resumeId: 2
                    }],
                shills: [{
                    id: 1,
                    name: 'Java',
                    percentage: 25,
                    resumeId: 2
                }]
            }
        },
        created() {
            this.getResumeId();
        },
        methods: {
            getResumeId() {
                this.id = parseInt(this.$route.query.id);
                if (typeof (this.id) == "undefined" || isNaN(this.id)|| this.id <= 0) {
                    this.$router.push('/')
                } else {
                  this.getResume()
                }

            },
            getResume() {

            },
            goBack(){
                this.$router.back(-1);
            }
        }
    }
</script>

<style lang="scss">

    .el-menu-vertical-demo:not(.el-menu--collapse) {
        margin: 10px 20px;
    }

    .header {
        margin: 0 auto;
        line-height: 60px;
    }


</style>

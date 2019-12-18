<template>
    <div>
        <my-menu :active-index="'1'"></my-menu>
        <el-card>
            <el-tabs>
                <el-tab-pane label="招聘信息">
                    <el-card style="width: auto">
                        <div >
                            <span>{{job.position}}</span>
                            <el-divider class="el-divider--vertical"></el-divider>
                            <span>{{job.department}}</span>
                            <el-divider class="el-divider--vertical"></el-divider>
                            <span>{{job.startDate}} - {{job.endDate}}</span>
                            <el-divider class="el-divider--vertical"></el-divider>
                            <span>{{job.address}}</span>
                            <el-divider></el-divider>
                            <span>
                                {{job.description}}
                            </span>
                            <el-divider></el-divider>
                            <span>
                                {{job.required}}
                            </span>
                            <el-divider></el-divider>
                        </div>

                        <el-popover
                                placement="right"
                                v-model="visible"
                                @hide="cancelUpdate"
                        >
                            <el-card shadow="hover" style="width: 400px;">

                                <el-form style="z-index: 998">
                                    <el-form-item label="职位">
                                        <el-input v-model="tempJob.position"></el-input>
                                    </el-form-item>
                                    <el-form-item label="部门">
                                        <el-input v-model="tempJob.department"></el-input>
                                    </el-form-item>
                                    <el-form-item label="薪资">
                                        <el-input v-model="tempJob.salary" type="number"></el-input>
                                    </el-form-item>
                                    <el-form-item label="地点">
                                        <el-input v-model="tempJob.address"></el-input>
                                    </el-form-item>

                                    <el-form-item label="开始日期">
                                        <div class="block">
                                            <el-date-picker
                                                    v-model="tempJob.startDate"
                                                    type="date"
                                                    :default-value="tempJob.startDate"
                                                    format="yyyy-M-d"
                                                    value-format="yyyy-M-d"
                                                    :clearable=false>
                                            </el-date-picker>
                                        </div>
                                    </el-form-item>
                                    <el-form-item label="结束日期">
                                        <div class="block">
                                            <el-date-picker
                                                    v-model="tempJob.endDate"
                                                    type="date"
                                                    :default-value="tempJob.endDate"
                                                    format="yyyy-M-d"
                                                    value-format="yyyy-M-d"
                                                    :clearable=false>
                                            </el-date-picker>
                                        </div>
                                    </el-form-item>

                                    <el-form-item label="职责">
                                        <el-input
                                                type="textarea"
                                                placeholder="请输入内容"
                                                v-model="tempJob.description"
                                                maxlength="120"
                                                show-word-limit
                                        >
                                        </el-input>
                                    </el-form-item>
                                    <el-form-item label="要求">
                                        <el-input
                                                type="textarea"
                                                placeholder="请输入内容"
                                                v-model="tempJob.required"
                                                maxlength="1000"
                                                show-word-limit
                                        >
                                        </el-input>
                                    </el-form-item>
                                    <el-form-item>
                                        <el-button type="primary" @click="update">更新</el-button>
                                        <el-button type="primary" @click="cancelUpdate">取消</el-button>
                                    </el-form-item>
                                </el-form>

                            </el-card>
                            <el-icon class="el-icon-edit" style="color: red" slot="reference"></el-icon>
                        </el-popover>
                    </el-card>
                </el-tab-pane>
                <el-tab-pane label="简历中心" :disabled="id === 0">
                    <el-timeline>
                        <el-timeline-item v-for="(item,index) of resumes" :key="index" :timestamp="item.date"
                                          placement="top">
                            <el-card shadow="hover">
                                <div style="padding: 14px;">
                                    <span>{{item.name}}</span>
                                    <div>{{item.email}}</div>
                                    <div>{{item.school}}</div>
                                    <el-icon class="el-icon-view" :style="item.viewed?'color:red':''"></el-icon>
                                </div>

                                <button class="el-button el-icon-search" @click="getDetails(index)"></button>
                            </el-card>
                        </el-timeline-item>
                    </el-timeline>
                </el-tab-pane>
                <el-tab-pane label="数据分析" :disabled="id === 0">

                </el-tab-pane>
            </el-tabs>
        </el-card>
    </div>
</template>

<script>

    import MyMenu from "../components/Menu/MyMenu";
    export default {
        name: "Job",
        components: {MyMenu},
        data() {
            return {
                id: -1,
                activeTab: 'activity',
                job: {},
                tempJob: {
                    id: -1,
                    startDate: '2019-1-1',
                    endDate: '2019-1-1',
                    position: '',
                    department: '',
                    staff: 0,
                    company: '',
                    salary: 0,
                    address: '',
                    description: '',
                    required: '',

                },
                visible: false,
                resumes: [],
                resume: {
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
            }
        },
        methods: {
            getResumeId() {
                this.id = parseInt(this.$route.query.id);
                if (typeof (this.id) == "undefined" || isNaN(this.id) || this.id < 0) {
                    this.$router.push('/')
                } else {
                    if (this.id > 0)
                        this.getJob();

                }

            },
            getJob() {
                this.job = {
                    id: 5,
                    startDate: '2019-4-23',
                    endDate: '2019-6-27',
                    position: 'Java后端研发',
                    department: '后端研发',
                    staff: 1000,
                    company: '腾讯',
                    salary: 20000,
                    address: '深圳',
                    description:
                        '1、负责接口开发与维护；\n' +
                        '\n' +
                        '2、提升接口的安全、性能等。',
                    required: '1、计算机或相关专业毕业，一年以上Java服务端开发经验；\n' +
                        '\n' +
                        '2、熟练使用Spring、myBatis等常用框架；\n' +
                        '\n' +
                        '3、熟悉 Java 的最新规范，熟练使用 Future、Lambda 表达式、Stream 操作等；\n' +
                        '\n' +
                        '4、熟练运用数据库MySQL、Oracle，并能进行数据库的数据结构设计；\n' +
                        '\n' +
                        '5、熟悉 Springboot、Redis、RabbitMQ等中间件；\n' +
                        '\n' +
                        '6、熟悉HTTPS、Web Socket、TCP/IP等网络协议；\n' +
                        '\n' +
                        '7、熟悉github开发工具的使用；\n' +
                        '\n' +
                        '8、具有Linux上的开发经验，熟悉命令行，能够编写基本的Shell脚本；\n' +
                        '\n' +
                        '9、具备工程化思维，有较好的问题分析与解决能力；\n' +
                        '\n' +
                        '10、具有良好的设计思维，能够高效地提供安全、高性能、可扩展的技术方案；\n' +
                        '\n' +
                        '11、对新技术充满热情，积极学习，具有高度的责任心以及良好团队合作精神。'
                };
                this.tempJob = JSON.parse(JSON.stringify(this.job));
                this.resumes = [{
                    id: 1,
                    name: 'shane',
                    date: '2019-12-4',
                    email: 'shaneann@163.com',
                    school: '复旦大学',
                    viewed: false
                }, {
                    id: 2,
                    name: 'xin',
                    date: '2019-12-6',
                    email: '123@163.com',
                    school: '西南某高校',
                    viewed: true
                }, {
                    id: 3,
                    name: 'hun',
                    date: '2019-12-6',
                    email: '152@gmail.com',
                    school: '华东理工大学',
                    viewed: false
                }]

            },
            update() {
                this.visible = false;
                if (this.id === 0){
                    this.tempJob.id = 10
                }
                this.job = JSON.parse(JSON.stringify(this.tempJob));
            },
            cancelUpdate() {
                this.visible = false;
                this.tempJob = JSON.parse(JSON.stringify(this.job));
            },
            getDetails(index) {
                if (!this.resumes[index].viewed) {
                    this.resumes[index].viewed = true;
                }
                console.log(this.resumes[index].id);
                this.$router.push({
                    path:'/resume',
                    query:{
                        id:this.resumes[index].id
                    }
                })
            },

        },
        created() {
            this.getResumeId();
        }
    }
</script>

<style scoped>

</style>

<template>
    <div>
        <my-menu :active-index="'1'"></my-menu>
        <el-card>
            <el-tabs>
                <el-tab-pane label="招聘信息">
                    <el-card>
                        <div style="padding: 14px;">
                            <span>{{job.position}}</span>
                            <div>{{job.department}}</div>
                            <div>{{job.startDate}} - {{job.endDate}}</div>
                            <div>{{job.address}}</div>
                            <div style="width: 400px">
                                {{job.description}}
                            </div>
                            <div>
                                {{job.required}}
                            </div>
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
        name: "Resume",
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
                    required: ''
                },
                visible: false
            }
        },
        methods: {
            getResumeId() {
                this.id = parseInt(this.$route.query.id);
                if (typeof (this.id) == "undefined" || isNaN(this.id) || this.id < 0) {
                    this.$router.push('/')
                } else {
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
                this.tempJob = JSON.parse(JSON.stringify(this.job))
            },
            update() {
                this.visible = false;
                this.job = JSON.parse(JSON.stringify(this.tempJob));
            },
            cancelUpdate() {
                this.visible = false;
                this.tempJob = JSON.parse(JSON.stringify(this.job));
            }
        },
        created() {
            this.getResumeId();
        }
    }
</script>

<style scoped>

</style>

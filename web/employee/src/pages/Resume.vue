<template>

    <el-container>
        <el-header>
            <my-menu></my-menu>
        </el-header>

        <el-container style=" background-color: white;margin: 0 20px">
            <el-main>
                <el-container id="basicInfo">
                    <el-header>
                        <div class="header">基本信息</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main style="overflow: visible">
                        <flip-card ref="flipCard">
                            <template slot="front">
                                <el-card shadow="hover">
                                    <div v-if="!this.isNew">
                                        <div>姓名：{{person.name}} | {{person.gender === 0?'男':'女'}} |
                                            {{person.birthday}}
                                        </div>
                                        <div>邮箱：{{person.email}}</div>
                                        <div>电话: {{person.phone}}</div>
                                        <div>地址：{{person.live}}</div>
                                    </div>

                                </el-card>
                            </template>
                            <template slot="back">

                                <el-popover
                                        placement="top"
                                        v-model="vi"
                                        @hide="cancel">
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label.trim="姓名">
                                                <el-input v-model.trim="tempPerson.name"/>
                                            </el-form-item>
                                            <el-form-item label="性别">
                                                <el-radio-group v-model="tempPerson.gender">
                                                    <el-radio :label="0">男</el-radio>
                                                    <el-radio :label="1">女</el-radio>
                                                </el-radio-group>
                                            </el-form-item>
                                            <el-form-item label="生日">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempPerson.birthday"
                                                            type="date"
                                                            :default-value="tempPerson.birthday"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="邮箱">
                                                <el-input v-model="tempPerson.email" :disabled="true"></el-input>
                                            </el-form-item>
                                            <el-form-item label="电话">
                                                <el-input v-model.trim="tempPerson.phone"></el-input>
                                            </el-form-item>
                                            <el-form-item label="地址">
                                                <el-input v-model.trim="tempPerson.live"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="submit">更新</el-button>
                                                <el-button type="primary" @click="cancel">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <el-icon class="el-icon-edit" slot="reference"></el-icon>
                                </el-popover>
                            </template>
                        </flip-card>
                    </el-main>
                </el-container>
                <el-divider></el-divider>

                <el-container id="objective" style="z-index: 998">
                    <el-header>
                        <div class="header">求职意向</div>
                    </el-header>
                    <el-divider></el-divider>
                    <el-main style="overflow: visible">

                        <flip-card ref="flipCard1" v-if="!isNew">
                            <template slot="front">
                                <el-card shadow="hover">
                                    <div>
                                        <div>薪水：{{objective.salary}}</div>
                                        <div>职位：{{objective.place}} | {{objective.position}}</div>
                                        <div>类型：{{objective.type === 0?'兼职':'全职'}}</div>
                                    </div>

                                </el-card>
                            </template>
                            <template slot="back">


                                <el-popover
                                        placement="top"
                                        v-model="vi1"
                                        @hide="cancelObjective">
                                    <el-card shadow="hover">
                                        <el-form style="z-index: 998">
                                            <el-form-item label.trim="薪水">
                                                <el-input v-model.trim="tempObject.salary" type="number" min="0"/>
                                            </el-form-item>
                                            <el-form-item label="部门">
                                                <el-input v-model="tempObject.place"></el-input>
                                            </el-form-item>
                                            <el-form-item label="职位">
                                                <el-input v-model.trim="tempObject.position"></el-input>
                                            </el-form-item>
                                            <el-form-item label="类型">
                                                <el-radio-group v-model="tempObject.type">
                                                    <el-radio :label="0">兼职</el-radio>
                                                    <el-radio :label="1">全职</el-radio>
                                                </el-radio-group>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="updateObjective">更新</el-button>
                                                <el-button type="primary" @click="cancelObjective">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <el-icon class="el-icon-edit" slot="reference"></el-icon>
                                </el-popover>
                            </template>
                        </flip-card>
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

                                <el-popover
                                        placement="top"
                                        v-model="vis[key]"
                                        @hide="cancelWork(key)"
                                        @show="getWork(key)">
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempWork.startTime"
                                                            type="date"
                                                            :default-value="tempWork.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempWork.endTime"
                                                            type="date"
                                                            :default-value="tempWork.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="公司">
                                                <el-input v-model.trim="tempWork.company"></el-input>
                                            </el-form-item>
                                            <el-form-item label="部门">
                                                <el-input v-model.trim="tempWork.department"></el-input>
                                            </el-form-item>
                                            <el-form-item label="职位">
                                                <el-input v-model.trim="tempWork.position"></el-input>
                                            </el-form-item>
                                            <el-form-item label="描述">
                                                <el-input v-model.trim="tempWork.description"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="updateWork(key)">更新</el-button>
                                                <el-button type="primary" @click="cancelWork(key)">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <i class="el-icon-edit" slot="reference"
                                       style="margin:  10px;position: relative"></i>

                                </el-popover>
                                <i class="el-icon-delete" style="margin:  10px;position: relative"
                                   @click="deleteWork(key)"></i>
                            </div>

                        </el-card>
                        <el-card shadow="hover" style="margin: 10px auto">
                            <div>

                                <el-popover
                                        placement="top"
                                        v-model="createWorkVisible"
                                        @hide="cancelCreateWork"
                                >
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempWork.startTime"
                                                            type="date"
                                                            :default-value="tempWork.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempWork.endTime"
                                                            type="date"
                                                            :default-value="tempWork.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="公司">
                                                <el-input v-model.trim="tempWork.company"></el-input>
                                            </el-form-item>
                                            <el-form-item label="部门">
                                                <el-input v-model.trim="tempWork.department"></el-input>
                                            </el-form-item>
                                            <el-form-item label="职位">
                                                <el-input v-model.trim="tempWork.position"></el-input>
                                            </el-form-item>
                                            <el-form-item label="描述">
                                                <el-input v-model.trim="tempWork.description"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="createWork">更新</el-button>
                                                <el-button type="primary" @click="cancelCreateWork">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <el-button class="el-icon-circle-plus-outline" slot="reference" :disabled="isNew"></el-button>
                                </el-popover>
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

                                <el-popover
                                        placement="top"
                                        v-model="vProjects[key]"
                                        @hide="cancelProject(key)"
                                        @show="getProject(key)">
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempProject.startTime"
                                                            type="date"
                                                            :default-value="tempProject.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempProject.endTime"
                                                            type="date"
                                                            :default-value="tempProject.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="项目名称">
                                                <el-input v-model.trim="tempProject.projectName"></el-input>
                                            </el-form-item>
                                            <el-form-item label="描述">
                                                <el-input v-model.trim="tempProject.description"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="updateProject(key)">更新</el-button>
                                                <el-button type="primary" @click="cancelProject(key)">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <i class="el-icon-edit" slot="reference"
                                       style="margin:  10px;position: relative"></i>

                                </el-popover>
                                <i class="el-icon-delete" style="margin:  10px;position: relative"
                                   @click="deleteProject(key)"></i>
                            </div>

                        </el-card>
                        <el-card shadow="hover" style="margin: 10px auto;">
                            <div>

                                <el-popover
                                        placement="top"
                                        v-model="createProjectVisible"
                                        @hide="cancelCreateProject"
                                >
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempProject.startTime"
                                                            type="date"
                                                            :default-value="tempProject.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempProject.endTime"
                                                            type="date"
                                                            :default-value="tempProject.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="项目名称">
                                                <el-input v-model.trim="tempProject.projectName"></el-input>
                                            </el-form-item>
                                            <el-form-item label="描述">
                                                <el-input v-model.trim="tempProject.description"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="createProject">创建</el-button>
                                                <el-button type="primary" @click="cancelCreateProject">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <el-button class="el-icon-circle-plus-outline" slot="reference" :disabled="isNew"></el-button>
                                </el-popover>
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

                                <el-popover
                                        placement="top"
                                        v-model="vEducations[key]"
                                        @hide="cancelEducation(key)"
                                        @show="getEducation(key)">
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempEducation.startTime"
                                                            type="date"
                                                            :default-value="tempEducation.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempEducation.endTime"
                                                            type="date"
                                                            :default-value="tempEducation.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="学校名称">
                                                <el-input v-model.trim="tempEducation.schoolName"></el-input>
                                            </el-form-item>
                                            <el-form-item label="专业">
                                                <el-input v-model.trim="tempEducation.professional"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="updateEducation(key)">更新</el-button>
                                                <el-button type="primary" @click="cancelEducation(key)">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <i class="el-icon-edit" slot="reference"
                                       style="margin:  10px;position: relative"></i>

                                </el-popover>
                                <i class="el-icon-delete" style="margin:  10px;position: relative"
                                   @click="deleteEducation(key)"></i>
                            </div>

                        </el-card>
                        <el-card shadow="hover" style="margin: 10px auto">
                            <div>

                                <el-popover
                                        placement="top"
                                        v-model="createEducationVisible"
                                        @hide="cancelCreateEducaiton"
                                >
                                    <el-card shadow="hover">
                                        <el-form>
                                            <el-form-item label="开始日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempEducation.startTime"
                                                            type="date"
                                                            :default-value="tempEducation.startTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="结束日期">
                                                <div class="block">
                                                    <el-date-picker
                                                            v-model="tempEducation.endTime"
                                                            type="date"
                                                            :default-value="tempEducation.endTime"
                                                            format="yyyy-M-d"
                                                            value-format="yyyy-M-d"
                                                            :clearable=false>
                                                    </el-date-picker>
                                                </div>
                                            </el-form-item>
                                            <el-form-item label="学校名称">
                                                <el-input v-model.trim="tempEducation.schoolName"></el-input>
                                            </el-form-item>
                                            <el-form-item label="专业">
                                                <el-input v-model.trim="tempEducation.professional"></el-input>
                                            </el-form-item>
                                            <el-form-item>
                                                <el-button type="primary" @click="createEducation">创建</el-button>
                                                <el-button type="primary" @click="cancelCreateEducaiton">取消</el-button>
                                            </el-form-item>
                                        </el-form>
                                    </el-card>
                                    <el-button class="el-icon-circle-plus-outline" slot="reference" :disabled="isNew"></el-button>
                                </el-popover>
                            </div>

                        </el-card>
                    </el-main>
                </el-container>
            </el-main>
        </el-container>

        <quick-menu :menu-count=count :icon-class=icons :menu-url-list=list :background-color=backgroundColor
                    :color=color :position=position></quick-menu>


    </el-container>


</template>

<script>
    import MyMenu from "../components/Menu/MyMenu";
    import QuickMenu from "../components/quickMenu";
    import FlipCard from "../components/FlipCard";

    export default {
        name: "Resume",
        components: {FlipCard, QuickMenu, MyMenu},
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
                }],
                count: 5,
                icons: ["el-icon-user", "el-icon-rank", "el-icon-document", "el-icon-data-board", "el-icon-school"],
                list: [{url: 'basicInfo', title: '基本信息'}, {url: "objective", title: '求职意向'}, {
                    url: "work",
                    title: '工作经历'
                }, {url: 'project', title: '项目经历'}, {url: 'education', title: '教育经历'}],
                backgroundColor: '#17c4c5',
                color: '#ffffff',
                position: 'bottom-left',
                isOpenNewTab: false,
                tempPerson: {
                    id: -1,
                    name: '',
                    gender: 0,
                    phone: '',
                    email: sessionStorage.getItem('loginInfo'),
                    live: '',
                    birthday: '1970-1-1'
                },
                tempObject: {
                    id: -1,
                    salary: 0,
                    place: '',
                    position: '',
                    type: 1,
                    resumeId: -1
                },
                tempResume: {
                    id: 0,
                    name: ''
                },
                tempWork: {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    company: '',
                    position: '',
                    department: '',
                    description: '',
                    resumeId: -1
                },
                tempProject: {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    projectName: '',
                    description: '',
                    resumeId: -1
                },
                tempEducation: {

                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    schoolName: '',
                    professional: '',
                    resumeId: -1

                },
                vi: false,
                vi1: false,
                createWorkVisible: false,
                createProjectVisible: false,
                createEducationVisible:false,
                vis: [],
                vProjects: [],
                vEducations:[]
            }
        },
        created() {
            this.getResumeId();
        },
        methods: {
            getResumeId() {
                this.id = parseInt(this.$route.query.id);
                if (typeof (this.id) == "undefined" || this.id < 0) {
                    this.$router.push('/')
                } else {
                    this.isNew = this.id === 0;


                    if (this.isNew) {
                        this.resume = JSON.parse(JSON.stringify(this.tempResume));
                        this.person = JSON.parse(JSON.stringify(this.tempPerson));
                        this.objective = JSON.parse(JSON.stringify(this.tempObject));
                        this.educations = [];
                        this.projects = [];
                        this.shills = [];
                        this.works = [];
                        this.vis = [];
                        this.vis.fill(false, 0, this.works.length);

                        this.projects = [];
                        this.vProjects = [];
                        this.vProjects.fill(false, this.projects.length);

                        this.educations = [];
                        this.vEducations = [];
                        this.vEducations.fill(false,this.educations.length);
                    } else {
                        this.tempPerson = JSON.parse(JSON.stringify(this.person));
                        this.tempObject = JSON.parse(JSON.stringify(this.objective));

                    }
                }

            },
            getResume() {

            },
            locateTo(id) {
                document.getElementById(id).scrollIntoView();
            },
            submit() {
                this.vi = false;
                this.person = JSON.parse(JSON.stringify(this.tempPerson));
                this.$refs['flipCard'].changeState(false);
                this.isNew = false;
            },
            cancel() {


                this.vi = false;
                this.tempPerson = JSON.parse(JSON.stringify(this.person));
                this.$refs['flipCard'].changeState(false);

            },
            updateObjective() {
                this.vi1 = false;
                this.objective = JSON.parse(JSON.stringify(this.tempObject));
                this.$refs['flipCard1'].changeState(false);
            },
            cancelObjective() {
                this.vi1 = false;
                this.tempObject = JSON.parse(JSON.stringify(this.objective));
                this.$refs['flipCard1'].changeState(false);
            },

            /*
            * 用于工作经历的操作,得到所选工作的信息
            * */
            getWork(key) {
                this.tempWork = JSON.parse(JSON.stringify(this.works[key]));
            },

            /*
            * 更新某项工作
            * */
            updateWork(key) {
                this.vis[key] = false;
                this.works[key] = JSON.parse(JSON.stringify(this.tempWork));
                this.tempWork = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    company: '',
                    position: '',
                    department: '',
                    description: '',
                    resumeId: -1
                }
            },
            /*
            * 取消更新工作经历操作
            * */
            cancelWork(key) {
                this.vis[key] = false;
                this.tempWork = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    company: '',
                    position: '',
                    department: '',
                    description: '',
                    resumeId: -1
                }

            },

            /*
            * 创建新的工作经历
            * */
            createWork() {
                this.works.push(JSON.parse(JSON.stringify(this.tempWork)));
                this.vis = [];
                this.vis.fill(false, this.works.length);
                this.tempWork = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    company: '',
                    position: '',
                    department: '',
                    description: '',
                    resumeId: -1
                };
                this.createWorkVisible = false;
            },

            /*
            * 取消创建新的工作经历
            * */
            cancelCreateWork() {
                this.tempWork = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    company: '',
                    position: '',
                    department: '',
                    description: '',
                    resumeId: -1
                };
                this.createWorkVisible = false;
            },

            /*
            * 删除工作经历
            * */
            deleteWork(key) {
                this.works.splice(key, 1);
                this.vis = [];
                this.vis.fill(false, this.works.length)
            },
            getProject(key) {
                this.tempProject = JSON.parse(JSON.stringify(this.projects[key]));
            },
            updateProject(key) {
                this.vProjects[key] = false;
                this.projects[key] = JSON.parse(JSON.stringify(this.tempProject));
                this.tempProject = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    projectName: '',
                    description: '',
                    resumeId: -1
                }
            },
            cancelProject(key) {
                this.vProjects[key] = false;
                this.tempProject = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    projectName: '',
                    description: '',
                    resumeId: -1
                }
            },
            createProject() {
                this.projects.push(JSON.parse(JSON.stringify(this.tempProject)));
                this.vProjects = [];
                this.vProjects.fill(false, this.projects.length);
                this.tempProject = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    projectName: '',
                    description: '',
                    resumeId: -1
                }
                this.createEducationVisible = false;
            },
            cancelCreateProject() {
                this.tempProject = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    projectName: '',
                    description: '',
                    resumeId: -1
                }
                this.createProjectVisible = false;
            },
            deleteProject(key) {
                this.projects.splice(key, 1);
                this.vProjects = [];
                this.vProjects.fill(false, this.projects.length)
            },

            getEducation(key) {
                this.tempEducation = JSON.parse(JSON.stringify(this.educations[key]));
            },
            updateEducation(key) {
                this.vEducations[key] = false;
                this.educations[key] = JSON.parse(JSON.stringify(this.tempEducation));
                this.tempEducation = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    schoolName: '',
                    professional: '',
                    resumeId: -1
                }
            },
            cancelEducation(key) {
                this.vEducations[key] = false;
                this.tempEducation = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    schoolName: '',
                    professional: '',
                    resumeId: -1
                }
            },
            createEducation() {
                this.educations.push(JSON.parse(JSON.stringify(this.tempEducation)));
                this.vEducations = [];
                this.vEducations.fill(false, this.educations.length);
                this.tempEducation = {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    schoolName: '',
                    professional: '',
                    resumeId: -1
                }
                this.createEducationVisible = false;
            },
            cancelCreateEducaiton() {
                this.tempEducation= {
                    id: -1,
                    startTime: '2019-1-1',
                    endTime: '2019-1-1',
                    schoolName: '',
                    professional: '',
                    resumeId: -1
                }
                this.createEducationVisible = false;
            },
            deleteEducation(key) {
                this.educations.splice(key, 1);
                this.vEducations = [];
                this.vEducations.fill(false, this.educations.length)
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

    .el-divider {
        width: 600px;
        margin: auto;
    }

    .el-card{
        width: 500px;
    }

</style>

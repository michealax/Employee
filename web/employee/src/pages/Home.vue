<template>
    <div>
        <my-menu :active-index="'1'"></my-menu>
        <el-card style="width: auto">
            <div>
                <el-tag style="margin: 10px 10px">职位</el-tag>
                <el-tag
                        :key="index"
                        v-for="(tag,index) in positions"
                        :disable-transitions="false"
                        @click="handlePosition(tag)"

                        :effect="tag.active?'dark':'plain'"
                >
                    {{tag.tag}}
                </el-tag>
            </div>
            <div>
                <el-tag>地点</el-tag>
                <el-tag
                        :key="index"
                        v-for="(tag,index) in cities"
                        :disable-transitions="false"
                        @click="handleCity(tag)"
                        :effect="tag.active?'dark':'plain'"
                >
                    {{tag.tag}}
                </el-tag>
            </div>
            <el-tag v-model="isRe"
                    @click="handleRe"
                    :effect="isRe?'dark':'plain'"
            >
                为我推荐
            </el-tag>
        </el-card>
        <div class="result">

            <el-timeline>
                <el-timeline-item v-for="(item, index) in tempJobs" :key="index" :timestamp="item.date">
                    <el-popover trigger="click"
                                placement="bottom" class="item">
                        <el-card>
                            <div><span>薪资:</span>{{item.salary}} 元/月</div>
                            <div><span>地点:</span>{{item.address}}</div>
                            <div><span>职责:</span>{{item.description}}</div>
                            <div><span>要求:</span>{{item.required}}</div>
                        </el-card>
                        <el-card shadow="hover" slot="reference">
                            <div class="el-header">{{item.position}}</div>
                            <div>{{item.company}} | {{item.salary}} 元/月 | {{item.address}}</div>
                        </el-card>
                    </el-popover>
                </el-timeline-item>
            </el-timeline>

        </div>

    </div>
</template>

<script>
    import MyMenu from "../components/Menu/MyMenu";

    export default {
        name: "Home",
        components: {MyMenu},
        data() {
            return {
                position: {
                    id: -1,
                    tag: "全部"
                },
                city: {
                    id: -1,
                    tag: "全部"
                },
                positions: [
                    {
                        id: -1,
                        tag: '全部',
                        active: true
                    },
                    {
                        id: 0,
                        tag: "后端",
                        active: false
                    }, {
                        id: 1,
                        tag: '前端',
                        active: false
                    }, {
                        id: 2,
                        tag: '金融',
                        active: false
                    }, {
                        id: 3,
                        tag: '算法',
                        active: false
                    }, {
                        id: 4,
                        tag: '会计',
                        active: false
                    }, {
                        id: 5,
                        tag: '产品经理',
                        active: false
                    }, {
                        id: 6,
                        tag: '市场分析师',
                        active: false
                    }, {
                        id: 7,
                        tag: '人力资源',
                        active: false
                    }
                ],
                cities: [{
                    id: -1,
                    tag: '全部',
                    active: true
                },
                    {
                        id: 0,
                        tag: '北京',
                        active: false
                    },
                    {
                        id: 1,
                        tag: '上海',
                        active: false
                    }, {
                        id: 2,
                        tag: '深圳',
                        active: false
                    }, {
                        id: 3,
                        tag: "成都",
                        active: false
                    }, {
                        id: 4,
                        tag: '杭州',
                        active: false
                    }, {
                        id: 5,
                        tag: '广州',
                        active: false
                    }, {
                        id: 6,
                        tag: '西安',
                        active: false
                    }, {
                        id: 7,
                        tag: '合肥',
                        active: false
                    }, {
                        id: 8,
                        tag: '南京',
                        active: false
                    }
                ],
                isRe: false,
                jobs: [],
                tempJobs: []
            }
        },
        methods: {
            handlePosition(position) {
                if (this.position.id !== position.id) {
                    this.position.id = position.id;
                    this.position.tag = position.tag;
                    for (let i in this.positions) {
                        this.positions[i].active = false;
                    }
                    position.active = true;
                    this.filter()


                }
            },
            handleCity(city) {

                if (this.city.id !== city.id) {

                    this.city.id = city.id;
                    this.city.tag = city.tag;
                    for (let i in this.cities) {
                        this.cities[i].active = false;
                    }
                    city.active = true;
                    this.filter()
                }
            },
            handleRe() {
                this.isRe = !this.isRe;

            },
            filter() {
                if (this.position.id >= 0 && this.city.id >= 0) {
                    this.tempJobs = this.jobs.filter((v) => {
                        return v.position.toLowerCase().indexOf(this.position.tag.toLowerCase()) >= 0;
                    });
                    this.tempJobs = this.tempJobs.filter((v) => {
                        return v.address.toLowerCase().indexOf(this.city.tag.toLowerCase()) >= 0;
                    });
                    return;
                }

                if (this.position.id >= 0) {
                    this.tempJobs = this.jobs.filter((v) => {
                        return v.position.toLowerCase().indexOf(this.position.tag.toLowerCase()) >= 0;
                    });

                    return;
                }

                if (this.city.id >= 0) {
                    this.tempJobs = this.jobs.filter((v) => {
                        return v.address.toLowerCase().indexOf(this.city.tag.toLowerCase()) >= 0;
                    });
                    return;
                }

                this.tempJobs = JSON.parse(JSON.stringify(this.jobs))

            }
        },
        created() {
            this.jobs = [
                {
                    id: 5,
                    date: '2019/4/23',
                    position: "Java后端研发",
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
                },
                {
                    id: 1,
                    date: '2019/4/22',
                    position: "后端研发工程师",
                    company: '华为',
                    salary: 12200,
                    address: '北京',
                    description: '',
                    required: '1、本科及以上学历，计算机软件专业毕业；\n' +
                        '\n' +
                        '2、3年以上JAVA/J2EE web开发经验；\n' +
                        '\n' +
                        '3、熟练掌握主流框架（Spring、Struts、Hibernate）的原理及使用；\n' +
                        '\n' +
                        '4、熟悉Linux系统及中间件配置，有开发文档编写能力；\n' +
                        '\n' +
                        '5、了解数据库开发，会用SQL语言（SQLServer, MySQL）；\n' +
                        '\n' +
                        '6、良好的学习能力，细致、耐心的工作态度，能够承受一定工作压力；\n' +
                        '\n' +
                        '7、有大型分布式、高并发、高负载系统设计开发经验者优先；\n' +
                        '\n' +
                        '8、能带领3人左右的小团队；\n' +
                        '\n' +
                        '9、求知欲强，工作严谨，积极负责，善于与人沟通。'
                },
                {
                    id: 3,
                    date: '2019/4/21',
                    position: "前端开发",
                    company: '腾讯',
                    salary: 10000,
                    address: "成都",
                    description: '1、负责各客户单位项目的系统开发及维护工作；\n' +
                        '2、按系统设计完成功能模块的编写；\n' +
                        '3、遵循工作规范，和编写要求；\n' +
                        '4、编写模块详细设计文档，和相关技术资料；\n' +
                        '5、按规范进行模块功能单元测试工作；\n' +
                        '6、维护所开发的软件模块代码；\n' +
                        '7、负责公司新系统的开发及研讨工作；\n' +
                        '8、负责撰写技术文档、系统说明书!',
                    required: '1、计算机相关专业，大专以上学历；\n' +
                        '2、2年以上J2EE服务器端和B/S系统开发工作经验，有互联网行业软件开发经验优先；\n' +
                        '3、精通Java语言及J2EE体系结构，熟悉HTML、Javascript、CSS；\n' +
                        '4、熟悉Spring，SSH，SpringMVC，MyBatis等开源框架；\n' +
                        '5、熟悉主流J2EE MVC架构，常用设计模式；\n' +
                        '6、熟练掌握Mysql、DB2或Oracle其中一种数据库开发；\n' +
                        '7、思维严密，上进心强，能吃苦耐劳；\n' +
                        '8、良好的阅读能力、理解能力、学习能力，思路清晰，工作规范；\n' +
                        '9、具有良好的编程习惯；良好的团队精神、沟通能力'
                },
                {
                    id: 12,
                    date: '2019/4/20',
                    position: "游戏研发",
                    company: '网易',
                    salary: 15000,
                    address: '杭州',
                    description: '1、进行软件系统分析、架构设计和核心技术开发；\n' +
                        '\n' +
                        '2、负责基于web服务后台/安全服务后台的开发和维护；\n' +
                        '\n' +
                        '3、了解互联网的技术发展、评估外部技术与解决方案。',
                    required: '1、全日制本科及以上学历,4年以上经验；\n' +
                        '\n' +
                        '2、扎实的java基础, 具有多线程、高并发开发经验，对JVM的原理有一定的了解；\n' +
                        '\n' +
                        '3、精通servlet，JMS/MQ，JDBC开发，熟悉Spring、myiBatis等开源框架，熟悉各种常用设计模式；\n' +
                        '\n' +
                        '4、熟悉互联网开发模式，清晰理解缓存，缓存设计和模式；\n' +
                        '\n' +
                        '5、熟悉分布式系统架构，熟悉Linux系统；\n' +
                        '\n' +
                        '6、良好的团队合作精神，较强的沟通、学习和解决问题的能力\n' +
                        '\n' +
                        '7、使用过微服务（spring cloud）优先'
                }
            ];
            this.tempJobs = JSON.parse(JSON.stringify(this.jobs))
        }

    }
</script>

<style lang="scss">
    .el-tag + .el-tag {
        margin-left: 10px;
    }

    .el-tag {
        cursor: pointer;
    }

    .result {
        width: auto;
        background: white;
    }

    .item {
        margin: 10px;
        width: 100px;
        height: 100px;
    }
</style>

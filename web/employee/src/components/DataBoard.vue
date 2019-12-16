<template>
    <div>
        <el-select
                v-model="value"
                multiple
                :multiple-limit=1
                filterable
                allow-create
                default-first-option
                placeholder="请选择职位查看"
                @change="changeChart">
            <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
        </el-select>
        <el-card shadow="hover" style="width: auto">
            <el-header style="line-height: 60px">专业-城市-数量-薪资分布</el-header>
            <div id="main" style="width: 600px;height: 400px;"></div>
        </el-card>

    </div>

</template>

<script>
    import echarts from 'echarts'

    export default {
        name: "DataBoard",
        data() {
            return {
                value: 0,
                options: [{
                    value: 0,
                    label: 'Java研发'
                }, {
                    value: 1,
                    label: '前端开发'
                }, {
                    value: 2,
                    label: '算法工程师'
                }, {
                    value: 3,
                    label: '会计师'
                }],
                salaryCity: [{
                    city: '上海',
                    salary: 15000,
                    num: 2000
                }, {
                    city: '深圳',
                    salary: 10000,
                    num: 1200
                }, {
                    city: '北京',
                    salary: 14000,
                    num: 1000
                }, {
                    city: '成都',
                    salary: 8000,
                    num: 800
                }, {
                    city: '杭州',
                    salary: 12000,
                    num: 600
                }, {
                    city: '广州',
                    salary: 11000,
                    num: 400
                }, {
                    city: '南京',
                    salary: 8000,
                    num: 300
                }]
            }
        },
        methods: {
            drawPie(id) {
                let cities = [];
                let salary = [];
                let num = [];
                for (let i in this.salaryCity) {
                    cities.push(this.salaryCity[i].city);
                    salary.push(this.salaryCity[i].salary);
                    num.push(this.salaryCity[i].num);
                }

                let pie = echarts.init(document.getElementById(id));
                let colors = ['#5793f3', '#d14a61', '#675bba'];
                pie.setOption(
                    {
                        color: colors,

                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross'
                            }
                        },
                        grid: {
                            right: '20%'
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {show: true}
                            }
                        },
                        legend: {
                            data: ['城市分布数量', '平均薪资']
                        },
                        xAxis: [
                            {
                                type: 'category',
                                axisTick: {
                                    alignWithLabel: true
                                },
                                data: cities
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value',
                                name: '城市分布数量',
                                min: 0,
                                max: 5000,
                                position: 'left',
                                axisLine: {
                                    lineStyle: {
                                        color: colors[0]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value} 个'
                                }
                            },
                            {
                                type: 'value',
                                name: '平均薪资',
                                min: 0,
                                max: 100000,
                                position: 'right',
                                axisLine: {
                                    lineStyle: {
                                        color: colors[1]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value} 元/月'
                                }
                            }
                        ],
                        series: [
                            {
                                name: '城市分布数量',
                                type: 'bar',
                                data: num
                            },
                            {
                                name: '平均薪资',
                                type: 'line',
                                yAxisIndex: 1,
                                data: salary
                            }
                        ]
                    })
            },
            changeChart() {
                if (this.value.length > 0) {
                    let index = this.value[0];
                    switch (index) {
                        case 0:
                            this.salaryCity = [{
                                city: '上海',
                                salary: 15000,
                                num: 2000
                            }, {
                                city: '深圳',
                                salary: 10000,
                                num: 1200
                            }, {
                                city: '北京',
                                salary: 14000,
                                num: 1000
                            }, {
                                city: '成都',
                                salary: 8000,
                                num: 800
                            }, {
                                city: '杭州',
                                salary: 12000,
                                num: 600
                            }, {
                                city: '广州',
                                salary: 11000,
                                num: 400
                            }, {
                                city: '南京',
                                salary: 8000,
                                num: 300
                            }];
                            break;
                        case 1:
                            this.salaryCity = [{
                                city: '上海',
                                salary: 10000,
                                num: 1000
                            }, {
                                city: '深圳',
                                salary: 10000,
                                num: 900
                            }, {
                                city: '北京',
                                salary: 12000,
                                num: 1200
                            }, {
                                city: '成都',
                                salary: 8500,
                                num: 900
                            }, {
                                city: '杭州',
                                salary: 10000,
                                num: 650
                            }, {
                                city: '广州',
                                salary: 11000,
                                num: 400
                            }, {
                                city: '南京',
                                salary: 8000,
                                num: 300
                            }];
                            break;
                        case 2:
                            this.salaryCity = [{
                                city: '上海',
                                salary: 14000,
                                num: 2000
                            }, {
                                city: '深圳',
                                salary: 9000,
                                num: 1100
                            }, {
                                city: '北京',
                                salary: 15000,
                                num: 1000
                            }, {
                                city: '成都',
                                salary: 8000,
                                num: 850
                            }, {
                                city: '杭州',
                                salary: 10500,
                                num: 600
                            }, {
                                city: '广州',
                                salary: 11000,
                                num: 350
                            }, {
                                city: '南京',
                                salary: 9000,
                                num: 300
                            }];
                            break;
                        case 3:
                            this.salaryCity = [{
                                city: '上海',
                                salary: 15000,
                                num: 2000
                            }, {
                                city: '深圳',
                                salary: 10000,
                                num: 1200
                            }, {
                                city: '北京',
                                salary: 14000,
                                num: 1000
                            }, {
                                city: '成都',
                                salary: 8000,
                                num: 800
                            }, {
                                city: '杭州',
                                salary: 12000,
                                num: 600
                            }, {
                                city: '广州',
                                salary: 11000,
                                num: 400
                            }, {
                                city: '南京',
                                salary: 8000,
                                num: 300
                            }];
                            break;
                        default:
                            this.salaryCity = [{
                                city: '上海',
                                salary: 15000,
                                num: 2000
                            }, {
                                city: '深圳',
                                salary: 10000,
                                num: 1200
                            }, {
                                city: '北京',
                                salary: 14000,
                                num: 1000
                            }, {
                                city: '成都',
                                salary: 8000,
                                num: 800
                            }, {
                                city: '杭州',
                                salary: 12000,
                                num: 600
                            }, {
                                city: '广州',
                                salary: 11000,
                                num: 400
                            }, {
                                city: '南京',
                                salary: 8000,
                                num: 300
                            }];
                    }
                    this.drawPie('main');
                }else {
                    this.salaryCity = [];
                    this.drawPie('main');
                }
            }
        },
        //调用
        mounted() {
            this.$nextTick(function () {
                this.drawPie('main')
            })
        },
        watch: {
            // value: function f(oldVal, newVal) {
            //  console.log(newVal)
            // switch (newVal) {
            //     case 0:
            //         this.salaryCity = [{
            //             city: '上海',
            //             salary: 15000,
            //             num: 2000
            //         }, {
            //             city: '深圳',
            //             salary: 10000,
            //             num: 1200
            //         }, {
            //             city: '北京',
            //             salary: 14000,
            //             num: 1000
            //         }, {
            //             city: '成都',
            //             salary: 8000,
            //             num: 800
            //         }, {
            //             city: '杭州',
            //             salary: 12000,
            //             num: 600
            //         }, {
            //             city: '广州',
            //             salary: 11000,
            //             num: 400
            //         }, {
            //             city: '南京',
            //             salary: 8000,
            //             num: 300
            //         }];
            //         break;
            //     case 1:
            //         this.salaryCity = [{
            //             city: '上海',
            //             salary: 10000,
            //             num: 1000
            //         }, {
            //             city: '深圳',
            //             salary: 10000,
            //             num: 900
            //         }, {
            //             city: '北京',
            //             salary: 12000,
            //             num: 1200
            //         }, {
            //             city: '成都',
            //             salary: 8500,
            //             num: 900
            //         }, {
            //             city: '杭州',
            //             salary: 10000,
            //             num: 650
            //         }, {
            //             city: '广州',
            //             salary: 11000,
            //             num: 400
            //         }, {
            //             city: '南京',
            //             salary: 8000,
            //             num: 300
            //         }];
            //         break;
            //     case 2:
            //         this.salaryCity = [{
            //             city: '上海',
            //             salary: 14000,
            //             num: 2000
            //         }, {
            //             city: '深圳',
            //             salary: 9000,
            //             num: 1100
            //         }, {
            //             city: '北京',
            //             salary: 15000,
            //             num: 1000
            //         }, {
            //             city: '成都',
            //             salary: 8000,
            //             num: 850
            //         }, {
            //             city: '杭州',
            //             salary: 10500,
            //             num: 600
            //         }, {
            //             city: '广州',
            //             salary: 11000,
            //             num: 350
            //         }, {
            //             city: '南京',
            //             salary: 9000,
            //             num: 300
            //         }];
            //         break;
            //     case 3:
            //         this.salaryCity = [{
            //             city: '上海',
            //             salary: 15000,
            //             num: 2000
            //         }, {
            //             city: '深圳',
            //             salary: 10000,
            //             num: 1200
            //         }, {
            //             city: '北京',
            //             salary: 14000,
            //             num: 1000
            //         }, {
            //             city: '成都',
            //             salary: 8000,
            //             num: 800
            //         }, {
            //             city: '杭州',
            //             salary: 12000,
            //             num: 600
            //         }, {
            //             city: '广州',
            //             salary: 11000,
            //             num: 400
            //         }, {
            //             city: '南京',
            //             salary: 8000,
            //             num: 300
            //         }];break;
            // }


            // this.drawPie('main');
            //  }
        }
    }
</script>

<style scoped>

</style>

<template>
    <div class="user-activity">
        <div class="post" v-for="(item, index) in resumes" :key="index">
            <el-card :body-style="{ padding: '20px' }">
                <div style="padding: 14px;">
                    <span>{{item.name}}</span>

                </div>
                <div class="bottom clearfix">
                    <el-button type="info" class="button el-icon-zoom-in"
                               @click="editResume(item.id)" circle>
                    </el-button>
                    <el-button type="danger" class="button el-icon-delete" circle
                               @click="deleteResume(item.id,index)"></el-button>
                </div>
            </el-card>
        </div>
        <div class="post">
            <el-card :body-style="{ padding: '0px' }">
                <div style="padding: 14px;">
                    <div class="bottom clearfix">
                        <el-button type="primary" class="button el-icon-circle-plus-outline" circle @click="addResume">
                        </el-button>
                    </div>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    const avatarPrefix = '?imageView2/1/w/80/h/80'
    const carouselPrefix = '?imageView2/2/h/440'

    export default {
        data() {
            return {
                carouselImages: [
                    'https://wpimg.wallstcn.com/9679ffb0-9e0b-4451-9916-e21992218054.jpg',
                    'https://wpimg.wallstcn.com/bcce3734-0837-4b9f-9261-351ef384f75a.jpg',
                    'https://wpimg.wallstcn.com/d1d7b033-d75e-4cd6-ae39-fcd5f1c0a7c5.jpg',
                    'https://wpimg.wallstcn.com/50530061-851b-4ca5-9dc5-2fead928a939.jpg'
                ],
                avatarPrefix,
                carouselPrefix,
                resumes: [
                    {
                        id: 1,
                        name: '我的简历1'
                    },
                    {
                        id: 3,
                        name: '我的简历2'
                    }
                ]

            }
        },
        methods: {
            editResume(id) {
                console.log(id);
                this.$router.push({
                    path:'/resume',
                    query:{
                        id:id
                    }
                })
            },
            deleteResume(id,index) {
                console.log(id);
                this.resumes.splice(index,1)
            },
            addResume() {
                console.log(sessionStorage.getItem('loginInfo'))
            }
        }
    }
</script>

<style lang="scss" scoped>
    .user-activity {
        .user-block {

            .username,
            .description {
                display: block;
                margin-left: 50px;
                padding: 2px 0;
            }

            .username {
                font-size: 16px;
                color: #000;
            }

            :after {
                clear: both;
            }

            .img-circle {
                border-radius: 50%;
                width: 40px;
                height: 40px;
                float: left;
            }

            span {
                font-weight: 500;
                font-size: 12px;
            }
        }

        .post {
            font-size: 14px;
            border-bottom: 1px solid #d2d6de;
            margin-bottom: 15px;
            padding-bottom: 15px;
            color: #666;

            .image {
                width: 100%;
                height: 100%;

            }

            .user-images {
                padding-top: 20px;
            }
        }

        .list-inline {
            padding-left: 0;
            margin-left: -5px;
            list-style: none;

            li {
                display: inline-block;
                padding-right: 5px;
                padding-left: 5px;
                font-size: 13px;
            }

            .link-black {

                &:hover,
                &:focus {
                    color: #999;
                }
            }
        }

    }

    .box-center {
        margin: 0 auto;
        display: table;
    }

    .text-muted {
        color: #777;
    }
</style>

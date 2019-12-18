<template>
    <div class="app-container">
        <my-menu :active-index="'1-1'"></my-menu>
        <div v-if="user">
            <el-row :gutter="20">

                <el-col :span="6" :xs="24">
                    <user-card :user="user"/>
                    <el-popover
                            placement="right"
                            v-model="visible"
                            @hide="cancelUpdate"
                   >
                        <el-card shadow="hover">

                            <el-form style="z-index: 998">
                                <el-form-item label="名称">
                                    <el-input v-model="tempUser.company"></el-input>
                                </el-form-item>
                                <el-form-item label="地点">
                                    <el-input v-model="tempUser.address"></el-input>
                                </el-form-item>
                                <el-form-item label="简介">
                                    <el-input
                                            type="textarea"
                                            placeholder="请输入内容"
                                            v-model="tempUser.description"
                                            maxlength="120"
                                            show-word-limit
                                    >
                                    </el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-input v-model="tempUser.staff" type="number"></el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="updateUser">更新</el-button>
                                    <el-button type="primary" @click="cancelUpdate">取消</el-button>
                                </el-form-item>
                            </el-form>

                        </el-card>
                        <el-icon class="el-icon-edit" style="color: red" slot="reference" ></el-icon>
                    </el-popover>

                </el-col>

                <el-col :span="18" :xs="24">
                    <el-card>
                        <el-tabs v-model="activeTab">
                            <el-tab-pane label="招聘信息" name="activity">
                                <activity/>
                            </el-tab-pane>
                            <el-tab-pane label="账户" name="account">
                                <account :user="user"/>
                            </el-tab-pane>
                        </el-tabs>
                    </el-card>
                </el-col>

            </el-row>
        </div>
    </div>
</template>

<script>
    // import {mapGetters} from 'vuex'
    import UserCard from '../components/profile/UserCard'
    import Activity from '../components/profile/Activity'
    import Account from '../components/profile/Account'
    import MyMenu from "../components/Menu/MyMenu";

    export default {
        name: 'Profile',
        components: {MyMenu, UserCard, Activity,  Account},
        data() {
            return {
                user: {},
                activeTab: 'activity',
                tempUser: {
                    id: -1,
                    username: '',
                    address: '',
                    description: '',
                    staff: 0,
                    company: ''
                },
                visible:false
            }
        },
        computed: {
            // ...mapGetters([
            //     'name',
            //     'avatar',
            //     'roles'
            // ])
        },
        created() {
            this.getUser()
        },
        methods: {

            getUser() {
                this.user = {
                    id: 1,
                    username: 'shane@163.com',
                    company:'腾讯',
                    address: '上海',
                    description: '中国第一家上市公司',
                    staff: 50
                };
                this.tempUser = JSON.parse(JSON.stringify(this.user))
            },
            logout() {
                sessionStorage.removeItem("loginInfo");
                this.$router.push("/")
            },
            updateUser(){
                this.visible = false;
                this.user = JSON.parse(JSON.stringify(this.tempUser))
            },
            cancelUpdate(){
                this.visible = false;
                this.tempUser = JSON.parse(JSON.stringify(this.user))
            }
        }
    }
</script>
<style lang="scss">
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }
</style>

<template>
    <div class="app-container">
        <el-menu default-active="1" class="el-menu-vertical-demo"  :collapse="true">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-setting" ></i>
                    <span slot="title">设置</span>
                </template>
                    <el-menu-item index="1-1" @click="logout">
                        <el-icon class="el-icon-switch-button"></el-icon>
                        <span >退出</span>
                    </el-menu-item>
                    <el-menu-item index="1-2">
                        <el-icon class="el-icon-info"></el-icon>
                        <span>
                            关于
                        </span>
                    </el-menu-item>
            </el-submenu>
        </el-menu>
        <div v-if="user">
            <el-row :gutter="20">

                <el-col :span="6" :xs="24">
                    <user-card :user="user"/>
                </el-col>

                <el-col :span="18" :xs="24">
                    <el-card>
                        <el-tabs v-model="activeTab">
                            <el-tab-pane label="Activity" name="activity">
                                <activity/>
                            </el-tab-pane>
                            <el-tab-pane label="Timeline" name="timeline">
                                <timeline/>
                            </el-tab-pane>
                            <el-tab-pane label="Account" name="account">
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
    import Timeline from '../components/profile/Timeline'
    import Account from '../components/profile/Account'

    export default {
        name: 'Profile',
        components: {UserCard, Activity, Timeline, Account},
        data() {
            return {
                user: {},
                activeTab: 'activity'
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
                    name: this.name,
                    role: '',
                    email: 'admin@test.com',
                    avatar: this.avatar
                }
            },
            logout() {
                sessionStorage.removeItem("loginInfo");
                this.$router.push("/")
            },
        }
    }
</script>
<style lang="scss">
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }
</style>

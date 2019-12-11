<template>
    <el-form>
        <el-form-item label="用户名">
            <el-input v-model.trim="user.username" :disabled="true"/>
        </el-form-item>
        <el-form-item label="旧密码">
            <el-input v-model="oldPassword" show-password=""/>
        </el-form-item>
        <el-form-item label="新密码">
            <el-input v-model="newPassword" show-password=""/>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submit">更新</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        props: {
            user: {
                type: Object,
                default: () => {
                    return {
                        id: -1,
                        username: ''
                    }
                }
            }
        },
        methods: {
            submit() {
                this.$message({
                    message: 'User information has been updated successfully',
                    type: 'success',
                    duration: 5 * 1000
                })
            }
        },
        data() {
            return {
                oldPassword:'',
                newPassword:''
            }
        }
    }
</script>

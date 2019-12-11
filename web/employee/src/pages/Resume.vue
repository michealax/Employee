<template>
    <div style="color: red">
        Resume
    </div>

</template>

<script>
    export default {
        name: "Resume",
        data(){
            return{
                id:-1
            }
        },
        created() {
            this.getResumeId();
        },
        methods:{
            getResumeId(){
                this.id = this.$route.query.id;
                if (typeof (this.id) == "undefined" || this.id === -1){
                    new Promise(resolve => {
                        resolve(this.$router.push('/'))
                    }).then(value => {
                        console.log(value)
                    })

                } else {
                    console.log(this.id)
                }

            },
            getResume(){

            }
        }
    }
</script>

<style scoped>

</style>

<template>
  <div class="block">




    <el-timeline>
      <el-card shadow="hover">
        <el-button class="button el-icon-circle-plus-outline" @click="addJob"></el-button>
      </el-card>

      <el-timeline-item v-for="(item,index) of jobs" :key="index" :timestamp="item.startDate" placement="top">
          <el-card shadow="hover">
            <div style="padding: 14px;">
              <span>{{item.position}}</span>
              <div>{{item.department}}</div>
              <div>{{item.startDate}} - {{item.endDate}}</div>
              <div>{{item.address}}</div>
            </div>
            <div class="bottom clearfix">
              <el-button type="info" class="button el-icon-zoom-in"
                         @click="editJob(item.id)" circle >
              </el-button>
              <el-button type="danger" class="button el-icon-delete" circle
                         @click="deleteJob(item.id)">
              </el-button>
            </div>
          </el-card>
      </el-timeline-item>
    </el-timeline>

  </div>
</template>

<script>

export default {
  data() {
    return {
      jobs:[{
        id:1,
        startDate:'2019/12/4',
        endDate:'2019/12/30',
        department:'后端研发',
        position:'JAVA后端研发',
        address:'上海'
      },{
        id:2,
        startDate:'2019/12/1',
        endDate:'2019/12/30',
        department:'前端研发',
        position:'UI研发',
        address:'上海'
      },{
        id:3,
        startDate:'2019/12/1',
        endDate:'2019/12/30',
        department:'前端研发',
        position:'UI研发',
        address:'深圳'
      }]
    }
  },
  methods:{
    editJob(id){
      this.$router.push({
        path:'/job',
        query:{
          id:id
        }
      })
    },
    deleteJob(id,index){
      this.jobs.splice(index,1)
    },
    addJob(){
      this.$router.push({
        path:'job',
        query:{
          id:0
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
</style>

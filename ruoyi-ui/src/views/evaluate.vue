<template>
  <div class="register">
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px" class="register-form">
      <h3 class="title">我要评价</h3>
      <el-form-item label="老师姓名" prop="teacher">
        <el-input v-model="formData.teacher.name" placeholder="请输入老师姓名" :maxlength="11" show-word-limit readonly
                  :disabled='true' :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="学生姓名" prop="student">
        <el-input v-model="formData.student.name" placeholder="请输入学生姓名" readonly :disabled='true'
                  :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="处理时间" prop="finalTime">
        <el-date-picker type="datetime" v-model="formData.finalTime" format="yyyy-MM-dd HH:mm:ss"
                        value-format="yyyy-MM-dd HH:mm:ss" :style="{width: '100%'}" placeholder="请选择处理时间"
                        readonly
                        :disabled='true'></el-date-picker>
      </el-form-item>
      <el-form-item label="问题类型" prop="proType">
        <el-input v-model="formData.proType.type" placeholder="请选择问题类型" readonly :disabled='true'
                  :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="评分" prop="score">
        <el-rate v-model="formData.score"></el-rate>
      </el-form-item>
      <el-form-item label="评价" prop="evaluateText">
        <el-input v-model="formData.evaluateText" type="textarea" placeholder="请输入评价"
                  :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {getJobFinal, saveJob} from "@/api/study/job";

export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        id: null,
        teacher: null,
        student: null,
        finalTime: null,
        proType: null,
        score: '',
        evaluateText: '',
      },
      rules: {
        score: [{
          required: true,
          message: '评分不能为空',
          trigger: 'change'
        }],
        evaluateText: [],
      },
    }
  },
  computed: {},
  watch: {},
  created() {
  },
  mounted() {
    this.getJog();
  },
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (valid) {
          this.formData.teacher = this.formData.teacher.id;
          this.formData.student = this.formData.student.id;
          this.formData.proType = this.formData.proType.id;
          saveJob(this.formData).then(response => {
            this.$modal.msgSuccess("提交成功");
            this.resetForm();
          });
        }
      })
    },
    getJog(){
      getJobFinal(this.$route.query.code).then(response => {
        this.formData = response.data;
      });
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>

<style rel="stylesheet/scss" lang="scss">
.register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}

.el-rate {
  display: inline-block;
  vertical-align: text-top;
}

.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.register-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;

  .el-input {
    height: 38px;

    input {
      height: 38px;
    }
  }

  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}

.register-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}

.register-code {
  width: 33%;
  height: 38px;
  float: right;

  img {
    cursor: pointer;
    vertical-align: middle;
  }
}

.el-register-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}

.register-code-img {
  height: 38px;
}
</style>

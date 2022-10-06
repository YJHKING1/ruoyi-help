<template>
  <div class="register">
    <el-form ref="pro" :model="formData" :rules="rules" size="medium" label-width="100px" class="register-form">
      <h3 class="title">我要问问题</h3>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="formData.name" placeholder="请输入姓名" clearable prefix-icon='el-icon-user-solid'
                  :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="formData.email" placeholder="请输入邮箱" clearable prefix-icon='el-icon-message'
                  :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="微信" prop="wechat">
        <el-input v-model="formData.wechat" placeholder="请输入微信" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="手机" prop="phone">
        <el-input v-model="formData.phone" placeholder="请输入手机" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="班级" prop="clazz">
        <el-select v-model="formData.clazz" placeholder="请选择班级" clearable :style="{width: '100%'}">
          <el-option
            v-for="item in clazzList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="预约日期" prop="proDate">
        <el-date-picker type="datetime" v-model="formData.proDate" format="yyyy-MM-dd HH:mm:ss"
                        value-format="yyyy-MM-dd HH:mm:ss" :style="{width: '100%'}" placeholder="请选择预约日期"
                        clearable>
        </el-date-picker>
      </el-form-item>
      <el-form-item label="问题类型" prop="proType">
        <el-select v-model="formData.proType" placeholder="请选择问题类型" clearable :style="{width: '100%'}">
          <el-option
            v-for="item in proTypeList"
            :key="item.id"
            :label="item.type"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="意向老师" prop="teacher">
        <el-select v-model="formData.teacher" placeholder="请选择意向老师" clearable :style="{width: '100%'}">
          <el-option
            v-for="item in teacherList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="问题描述" prop="proText">
        <el-input v-model="formData.proText" type="textarea" placeholder="请输入问题描述"
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
import {listClazz} from "@/api/study/clazz";
import {listProList, listTeacher} from "@/api/study/teacher";
import {addHelp} from "@/api/study/job";

export default {
  components: {},
  props: [],
  data() {
    return {
      clazzList: [],
      proTypeList: [],
      teacherList: [],
      formData: {
        name: '',
        email: '',
        wechat: '',
        phone: '',
        clazz: null,
        proDate: null,
        proType: null,
        teacher: null,
        proText: ''
      },
      rules: {
        name: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        email: [{
          required: true,
          message: '请输入邮箱',
          trigger: 'blur'
        }],
        wechat: [{
          required: true,
          message: '请输入微信',
          trigger: 'blur'
        }],
        phone: [{
          required: true,
          message: '请输入手机',
          trigger: 'blur'
        }],
        clazz: [],
        proDate: [{
          required: true,
          message: '请选择预约日期',
          trigger: 'change'
        }],
        proType: [{
          required: true,
          message: '请选择问题类型',
          trigger: 'change'
        }],
        teacher: [],
        proText: [{
          required: true,
          message: '请输入问题描述',
          trigger: 'blur'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {
  },
  mounted() {
    this.getClazzList();
    this.getTeacherList();
    this.getProTypeList();
  },
  methods: {
    submitForm() {
      this.$refs['pro'].validate(valid => {
        console.log(this.formData)
        if (valid) {
          addHelp(this.formData).then(response => {
            this.$modal.msgSuccess("申请成功");
            this.open = false;
            this.getList();
          });
        }
      })
    },
    resetForm() {
      this.$refs['pro'].resetFields()
    },
    getClazzList() {
      listClazz().then(res => {
        this.clazzList = res.rows;
      });
    },
    getProTypeList() {
      listProList().then(res => {
        this.proTypeList = res.rows;
      });
    },
    getTeacherList() {
      listTeacher().then(res => {
        this.teacherList = res.rows;
      });
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

<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="emps"
            v-loading="tableLoading"
            border
            stripe
            @selection-change="handleSelectionChange"
            size="mini"
            style="width: 100%">
            <el-table-column
              type="selection"
              align="left"
              width="30">
            </el-table-column>
            <el-table-column
              prop="name"
              align="left"
              fixed
              label="姓名"
              width="90">
            </el-table-column>
            <el-table-column
              prop="workID"
              width="85"
              align="left"
              label="工号">
            </el-table-column>
            <el-table-column
              prop="gender"
              label="性别"
              width="50">
            </el-table-column>
            <el-table-column
              width="85"
              align="left"
              label="出生日期">
              <template slot-scope="scope">{{ scope.row.birthday | formatDate}}</template>
            </el-table-column>
            <el-table-column
              prop="idCard"
              width="150"
              align="left"
              label="身份证号码">
            </el-table-column>
            <el-table-column
              prop="wedlock"
              width="70"
              label="婚姻状况">
            </el-table-column>
            <el-table-column
              width="50"
              prop="nation.name"
              label="民族">
            </el-table-column>
            <el-table-column
              prop="nativePlace"
              width="80"
              label="籍贯">
            </el-table-column>
            <el-table-column
              prop="politicsStatus.name"
              label="政治面貌">
            </el-table-column>
            <el-table-column
              prop="email"
              width="180"
              align="left"
              label="电子邮件">
            </el-table-column>
            <el-table-column
              prop="phone"
              width="100"
              label="电话号码">
            </el-table-column>
            <el-table-column
              prop="address"
              width="220"
              align="left"
              label="联系地址">
            </el-table-column>
            <el-table-column
              prop="department.name"
              align="left"
              width="100"
              label="所属部门">
            </el-table-column>
            <el-table-column
              width="100"
              align="left"
              prop="position.name"
              label="职位">
            </el-table-column>
            <el-table-column
              prop="jobLevel.name"
              width="100"
              align="left"
              label="职称">
            </el-table-column>
            <el-table-column
              prop="engageForm"
              label="聘用形式">
            </el-table-column>
            <el-table-column
              width="85"
              align="left"
              label="入职日期">
              <template slot-scope="scope">{{ scope.row.beginDate | formatDate}}</template>
            </el-table-column>
            <el-table-column
              width="85"
              align="left"
              label="转正日期">
              <template slot-scope="scope">{{ scope.row.conversionTime | formatDate}}</template>
            </el-table-column>
            <el-table-column
              width="95"
              align="left"
              label="合同起始日期">
              <template slot-scope="scope">{{ scope.row.beginContract | formatDate}}</template>
            </el-table-column>
            <el-table-column
              width="95"
              align="left"
              label="合同截至日期">
              <template slot-scope="scope">{{ scope.row.endContract | formatDate}}</template>
            </el-table-column>
            <el-table-column
              align="left"
              width="70"
              label="合同期限">
              <template slot-scope="scope">{{ scope.row.contractTerm}}年</template>
            </el-table-column>
            <el-table-column
              align="left"
              prop="tiptopDegree"
              label="最高学历">
            </el-table-column>
          </el-table>
          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-button type="danger" size="mini" v-if="emps.length>0" :disabled="multipleSelection.length==0"
                       @click="deleteManyEmps">批量删除
            </el-button>
            <el-pagination
              background
              :page-size="10"
              :current-page="currentPage"
              @current-change="currentChange"
              layout="prev, pager, next"
              :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        emps: [],
        keywords: '',
        beginDateScope: '',
        multipleSelection: [],
        totalCount: -1,
        currentPage: 1,
        tableLoading: false,
        emp: {
          name: '',
          gender: '',
          birthday: '',
          idCard: '',
          wedlock: '',
          nationId: '',
          nativePlace: '',
          politicId: '',
          email: '',
          phone: '',
          address: '',
          departmentId: '',
          departmentName: '所属部门...',
          jobLevelId: '',
          posId: '',
          engageForm: '',
          tiptopDegree: '',
          specialty: '',
          school: '',
          beginDate: '',
          workState: '',
          workID: '',
          contractTerm: '',
          conversionTime: '',
          notWorkDate: '',
          beginContract: '',
          endContract: '',
          workAge: ''
        }
      };
    },
    mounted: function () {
      this.loadEmps();
    },
    methods: {
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.loadEmps();
      },
      loadEmps() {
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/employee/basic/emp?page=" + this.currentPage +
          "&size=10&keywords=" + this.keywords + "&politicId=" + this.emp.politicId +
          "&nationId=" + this.emp.nationId + "&posId=" + this.emp.posId + "&jobLevelId=" +
          this.emp.jobLevelId + "&engageForm=" + this.emp.engageForm + "&departmentId=" +
          this.emp.departmentId + "&beginDateScope=" + this.beginDateScope).then(resp => {
          this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.emps = data.emps;
            _this.totalCount = data.count;
            //            _this.emptyEmpData();
          }
        })
      }
    }
  };
</script>
<style>
  .el-dialog__body {
    padding-top: 0px;
    padding-bottom: 0px;
  }

  .slide-fade-enter-active {
    transition: all .8s ease;
  }

  .slide-fade-leave-active {
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to {
    transform: translateX(10px);
    opacity: 0;
  }
</style>

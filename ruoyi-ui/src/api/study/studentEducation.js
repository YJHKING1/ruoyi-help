import request from '@/utils/request'

// 查询学历列表
export function listStudentEducation(query) {
  return request({
    url: '/study/studentEducation/list',
    method: 'get',
    params: query
  })
}

// 查询学历详细
export function getStudentEducation(id) {
  return request({
    url: '/study/studentEducation/' + id,
    method: 'get'
  })
}

// 新增学历
export function addStudentEducation(data) {
  return request({
    url: '/study/studentEducation',
    method: 'post',
    data: data
  })
}

// 修改学历
export function updateStudentEducation(data) {
  return request({
    url: '/study/studentEducation',
    method: 'put',
    data: data
  })
}

// 删除学历
export function delStudentEducation(id) {
  return request({
    url: '/study/studentEducation/' + id,
    method: 'delete'
  })
}

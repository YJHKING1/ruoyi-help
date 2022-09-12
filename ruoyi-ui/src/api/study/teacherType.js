import request from '@/utils/request'

// 查询教师类型列表
export function listTeacherType(query) {
  return request({
    url: '/study/teacherType/list',
    method: 'get',
    params: query
  })
}

// 查询教师类型详细
export function getTeacherType(id) {
  return request({
    url: '/study/teacherType/' + id,
    method: 'get'
  })
}

// 新增教师类型
export function addTeacherType(data) {
  return request({
    url: '/study/teacherType',
    method: 'post',
    data: data
  })
}

// 修改教师类型
export function updateTeacherType(data) {
  return request({
    url: '/study/teacherType',
    method: 'put',
    data: data
  })
}

// 删除教师类型
export function delTeacherType(id) {
  return request({
    url: '/study/teacherType/' + id,
    method: 'delete'
  })
}

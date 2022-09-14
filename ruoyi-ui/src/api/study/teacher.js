import request from '@/utils/request'

// 查询教师列表
export function listTeacher(query) {
  return request({
    url: '/study/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询教师详细
export function getTeacher(id) {
  return request({
    url: '/study/teacher/' + id,
    method: 'get'
  })
}

// 新增教师
export function addTeacher(data) {
  return request({
    url: '/study/teacher',
    method: 'post',
    data: data
  })
}

// 修改教师
export function updateTeacher(data) {
  return request({
    url: '/study/teacher',
    method: 'put',
    data: data
  })
}

// 删除教师
export function delTeacher(id) {
  return request({
    url: '/study/teacher/' + id,
    method: 'delete'
  })
}

// 查询问题类型
export function listProList(query) {
  return request({
    url: '/study/reserveType/list',
    method: 'get',
    params: query
  })
}

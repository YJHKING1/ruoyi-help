import request from '@/utils/request'

// 查询班级列表
export function listClazz(query) {
  return request({
    url: '/study/clazz/list',
    method: 'get',
    params: query
  })
}

// 查询班级详细
export function getClazz(id) {
  return request({
    url: '/study/clazz/' + id,
    method: 'get'
  })
}

// 新增班级
export function addClazz(data) {
  return request({
    url: '/study/clazz',
    method: 'post',
    data: data
  })
}

// 修改班级
export function updateClazz(data) {
  return request({
    url: '/study/clazz',
    method: 'put',
    data: data
  })
}

// 删除班级
export function delClazz(id) {
  return request({
    url: '/study/clazz/' + id,
    method: 'delete'
  })
}

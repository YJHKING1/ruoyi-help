import request from '@/utils/request'

// 查询就业帮扶列表
export function listJob(query) {
  return request({
    url: '/study/job/list',
    method: 'get',
    params: query
  })
}

// 查询就业帮扶详细
export function getJob(id) {
  return request({
    url: '/study/job/' + id,
    method: 'get'
  })
}

// 新增就业帮扶
export function addJob(data) {
  return request({
    url: '/study/job',
    method: 'post',
    data: data
  })
}

// 修改就业帮扶
export function updateJob(data) {
  return request({
    url: '/study/job',
    method: 'put',
    data: data
  })
}

// 删除就业帮扶
export function delJob(id) {
  return request({
    url: '/study/job/' + id,
    method: 'delete'
  })
}

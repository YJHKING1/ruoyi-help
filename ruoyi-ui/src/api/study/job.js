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
    timeout: 20000,
    data: data
  })
}

// 修改就业帮扶
export function updateJob(data) {
  return request({
    url: '/study/job',
    method: 'put',
    timeout: 20000,
    data: data
  })
}

// 保存评价
export function saveJob(data) {
  return request({
    url: '/study/job/saveJob',
    method: 'put',
    timeout: 20000,
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

// 帮扶申请
// 新增就业帮扶
export function addHelp(data) {
  return request({
    url: '/study/job/help',
    method: 'post',
    timeout: 20000,
    data: data
  })
}
// 查询
export function getJobFinal(id) {
  return request({
    url: '/study/job/getJobFinal/' + id,
    method: 'get'
  })
}

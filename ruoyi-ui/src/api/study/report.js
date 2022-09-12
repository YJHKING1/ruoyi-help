import request from '@/utils/request'

// 查询报表统计列表
export function listReport(query) {
  return request({
    url: '/study/report/list',
    method: 'get',
    params: query
  })
}

// 查询报表统计详细
export function getReport(id) {
  return request({
    url: '/study/report/' + id,
    method: 'get'
  })
}

// 新增报表统计
export function addReport(data) {
  return request({
    url: '/study/report',
    method: 'post',
    data: data
  })
}

// 修改报表统计
export function updateReport(data) {
  return request({
    url: '/study/report',
    method: 'put',
    data: data
  })
}

// 删除报表统计
export function delReport(id) {
  return request({
    url: '/study/report/' + id,
    method: 'delete'
  })
}

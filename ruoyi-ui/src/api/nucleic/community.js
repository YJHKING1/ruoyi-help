import request from '@/utils/request'

// 查询小区列表
export function listCommunity(query) {
  return request({
    url: '/nucleic/community/list',
    method: 'get',
    params: query
  })
}

// 查询小区详细
export function getCommunity(id) {
  return request({
    url: '/nucleic/community/' + id,
    method: 'get'
  })
}

// 新增小区
export function addCommunity(data) {
  return request({
    url: '/nucleic/community',
    method: 'post',
    data: data
  })
}

// 修改小区
export function updateCommunity(data) {
  return request({
    url: '/nucleic/community',
    method: 'put',
    data: data
  })
}

// 删除小区
export function delCommunity(id) {
  return request({
    url: '/nucleic/community/' + id,
    method: 'delete'
  })
}

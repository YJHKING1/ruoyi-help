import request from '@/utils/request'

// 查询住户列表
export function listResident(query) {
  return request({
    url: '/nucleic/resident/list',
    method: 'get',
    params: query
  })
}

// 查询住户详细
export function getResident(id) {
  return request({
    url: '/nucleic/resident/' + id,
    method: 'get'
  })
}

// 新增住户
export function addResident(data) {
  return request({
    url: '/nucleic/resident',
    method: 'post',
    data: data
  })
}

// 修改住户
export function updateResident(data) {
  return request({
    url: '/nucleic/resident',
    method: 'put',
    data: data
  })
}

// 删除住户
export function delResident(id) {
  return request({
    url: '/nucleic/resident/' + id,
    method: 'delete'
  })
}

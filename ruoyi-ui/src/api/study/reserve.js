import request from '@/utils/request'

// 查询帮扶预约列表
export function listReserve(query) {
  return request({
    url: '/study/reserve/list',
    method: 'get',
    params: query
  })
}

// 查询帮扶预约详细
export function getReserve(id) {
  return request({
    url: '/study/reserve/' + id,
    method: 'get'
  })
}

// 新增帮扶预约
export function addReserve(data) {
  return request({
    url: '/study/reserve',
    method: 'post',
    data: data
  })
}

// 修改帮扶预约
export function updateReserve(data) {
  return request({
    url: '/study/reserve',
    method: 'put',
    data: data
  })
}

// 删除帮扶预约
export function delReserve(id) {
  return request({
    url: '/study/reserve/' + id,
    method: 'delete'
  })
}

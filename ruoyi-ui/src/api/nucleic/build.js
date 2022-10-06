import request from '@/utils/request'

// 查询楼栋列表
export function listBuild(query) {
  return request({
    url: '/nucleic/build/list',
    method: 'get',
    params: query
  })
}

// 查询楼栋详细
export function getBuild(id) {
  return request({
    url: '/nucleic/build/' + id,
    method: 'get'
  })
}

// 新增楼栋
export function addBuild(data) {
  return request({
    url: '/nucleic/build',
    method: 'post',
    data: data
  })
}

// 修改楼栋
export function updateBuild(data) {
  return request({
    url: '/nucleic/build',
    method: 'put',
    data: data
  })
}

// 删除楼栋
export function delBuild(id) {
  return request({
    url: '/nucleic/build/' + id,
    method: 'delete'
  })
}

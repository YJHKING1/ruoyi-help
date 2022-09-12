import request from '@/utils/request'

// 查询就业问题类型列表
export function listJobProblemType(query) {
  return request({
    url: '/study/jobProblemType/list',
    method: 'get',
    params: query
  })
}

// 查询就业问题类型详细
export function getJobProblemType(id) {
  return request({
    url: '/study/jobProblemType/' + id,
    method: 'get'
  })
}

// 新增就业问题类型
export function addJobProblemType(data) {
  return request({
    url: '/study/jobProblemType',
    method: 'post',
    data: data
  })
}

// 修改就业问题类型
export function updateJobProblemType(data) {
  return request({
    url: '/study/jobProblemType',
    method: 'put',
    data: data
  })
}

// 删除就业问题类型
export function delJobProblemType(id) {
  return request({
    url: '/study/jobProblemType/' + id,
    method: 'delete'
  })
}

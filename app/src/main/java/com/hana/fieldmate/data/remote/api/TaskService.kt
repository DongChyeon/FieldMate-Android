package com.hana.fieldmate.data.remote.api

import com.hana.fieldmate.data.remote.model.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface TaskService {
    @Multipart
    @POST("/company/client/business/task")
    suspend fun createTask(
        @PartMap data: HashMap<String, RequestBody>,
        @Part images: List<MultipartBody.Part>
    ): Result<CreateTaskRes>

    @GET("/company/{companyId}/clients")
    suspend fun fetchClientList(@Path("companyId") companyId: Long): Result<ClientListRes>

    @GET("/company/{companyId}/client/business/task/categories")
    suspend fun fetchTaskCategoryList(
        @Path("companyId") companyId: Long
    ): Result<TaskCategoryListRes>

    @GET("/company/client/business/task/{taskId}")
    suspend fun fetchTaskById(@Path("taskId") taskId: Long): Result<TaskRes>

    @GET("/company/{companyId}/client/business/tasks")
    suspend fun fetchTaskList(
        @Path("companyId") companyId: Long,
        @Query("date") date: String,
        @Query("type") type: String
    ): Result<TaskListRes>
}
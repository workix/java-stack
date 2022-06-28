# Endpoints
## Contexts
 - [x] Android
 - [x] Vue
 - [x] RestFull

## Android
 - Class -> LoginEndpoint, PingEndpoint, SaveOrUpdateEndpoint
 - Path Prefix -> '/login'
 - Path Prefix -> '/ping'
 - Path Prefix -> '/save'
### Routes

#### login firebase
 - Path -> '/login/firebaselogin'
 - Verb -> Post

#### ping test
 - Path -> '/ping/test'
 - Verb -> Post

#### [save] user
 - Path -> '/save/user'
 - Verb -> Post

#### [save] candidate
- Path -> '/save/candidate'
- Verb -> Post

#### [save] resume
- Path -> '/save/resume'
- Verb -> Post

## Vue
 - Class -> VueEndpoint
 - Path Prefix -> '/vue'

### Routes

#### [Create] candidate
- Path -> '/vue/create_candidate'
- Verb -> Post

#### [Create] company
- Path -> '/vue/create_company'
- Verb -> Post

#### [Update] company or candidate
- Path -> '/vue/update_by_token'
- Verb -> Put

#### [Create or Update] resume
- Path -> '/vue/create_or_update_resume_by_token'
- Verb -> Post

#### [Create or Update] job
- Path -> '/vue/create_or_update_job_by_token'
- Verb -> Post

#### [Create or Update] selective process
- Path -> '/vue/create_or_update_sp_by_token'
- Verb -> Post

#### [Validate] cpf
- Path -> '/vue/validate_cpf'
- Verb -> Post

## Restfull [Authentication]
- Class -> AuthEndpoint
- Path Prefix -> '/auth'

### Routes [Auth]

#### [Login]
- Path -> '/auth/login'
- Verb -> Post

#### [Me] - About Me
- Path -> '/auth/me'
- Verb -> Get

## Restfull [Author]
- Class -> AuthorEndpoint
- Path Prefix -> '/authors'

#### [Create]
- Path -> '/authors'
- Verb -> Post

#### [Delete]
- Path -> '/authors'
- Verb -> Delete

#### [Get by Id]
- Path -> '/authors/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/authors'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/authors/<!id>'
- Verb -> Put

## Restfull [Blog]
- Class -> BlogEndpoint
- Path Prefix -> '/blogs'

#### [Create]
- Path -> '/blogs'
- Verb -> Post

#### [Delete]
- Path -> '/blogs'
- Verb -> Delete

#### [Get by Id]
- Path -> '/blogs/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/blogs'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/blogs/<!id>'
- Verb -> Put

#### [Get Categories]
- Path -> '/blogs/categories'
- Verb -> Get

#### [Get Time Periods] - Periods from Blogs Posts
- Path -> '/blogs/time_periods'
- Verb -> Get

#### [Get Recents]
- Path -> '/blogs/recents'
- Verb -> Get
- Query -> start,max

#### [Get Paginated]
- Path -> '/blogs/paginated'
- Verb -> Get
- Query -> page, limit

## Restfull [Candidate]
- Class -> CandidateEndpoint
- Path Prefix -> '/candidates'


#### [Create]
- Path -> '/candidates'
- Verb -> Post

#### [Delete]
- Path -> '/candidates'
- Verb -> Delete

#### [Get by Id]
- Path -> '/candidates/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/candidates'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/candidates/<!id>'
- Verb -> Put

#### [Get short list] Reduced Fields
- Path -> '/candidates/short_list'
- Verb -> Get
- Query -> start,max

#### [notify]
 - Path -> '/candidates/notify'
 - Verb -> Post


## Restfull [Comment]
- Class -> CommentEndpoint
- Path Prefix -> '/comments'

#### [Create]
- Path -> '/comments'
- Verb -> Post

#### [Delete]
- Path -> '/comments'
- Verb -> Delete

#### [Get by Id]
- Path -> '/comments/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/comments'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/comments/<!id>'
- Verb -> Put

#### [Get Recents]
- Path -> '/comments/recents'
- Verb -> Get
- Query -> start,max

#### [Create Blog Comment]
- Path -> '/comments/blog'
- Verb -> Post

## Restfull [Company]
- Class -> CompanyEndpoint
- Path Prefix -> '/companies'

#### [Create]
- Path -> '/companies'
- Verb -> Post

#### [Delete]
- Path -> '/companies'
- Verb -> Delete

#### [Get by Id]
- Path -> '/companies/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/companies'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/companies/<!id>'
- Verb -> Put

#### [Get Random Logos]
- Path -> '/companies/logos'
- Verb -> Get
- Query -> start,max


## Restfull [Form]
- Class -> FormEndpoint
- Path Prefix -> '/forms'

#### [Create]
- Path -> '/forms'
- Verb -> Post

#### [Delete]
- Path -> '/forms'
- Verb -> Delete

#### [Get by Id]
- Path -> '/forms/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/forms'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/forms/<!id>'
- Verb -> Put

## Restfull [JAAS Role]
- Class -> JAASRoleEndpoint
- Path Prefix -> '/jaasroles'

#### [Create]
- Path -> '/jaasroles'
- Verb -> Post

#### [Delete]
- Path -> '/jaasroles'
- Verb -> Delete

#### [Get by Id]
- Path -> '/jaasroles/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/jaasroles'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/jaasroles/<!id>'
- Verb -> Put

## Restfull [JAAS User]
- Class -> JAASUserEndpoint
- Path Prefix -> '/jaasusers'

#### [Create]
- Path -> '/jaasusers'
- Verb -> Post

#### [Delete]
- Path -> '/jaasusers'
- Verb -> Delete

#### [Get by Id]
- Path -> '/jaasusers/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/jaasusers'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/jaasusers/<!id>'
- Verb -> Put

## Restfull [Job]
- Class -> JobEndpoint
- Path Prefix -> '/jobs'

#### [Create]
- Path -> '/jobs'
- Verb -> Post

#### [Delete]
- Path -> '/jobs'
- Verb -> Delete

#### [Get by Id]
- Path -> '/jobs/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/jobs'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/jobs/<!id>'
- Verb -> Put

#### [Get Feature]
- Path -> '/jobs/feature'
- Verb -> Get
- Query -> start,max

#### [Get Random Featured]
- Path -> '/jobs/random_featured'
- Verb -> Get

#### [Get by company]
- Path -> '/jobs/company/<!id>'
- Verb -> Get

#### [Get Paginated]
- Path -> '/jobs/paginated'
- Verb -> Get
- Query -> page, limit

#### [Get My Jobs]
- Path -> '/jobs/my_jobs'
- Verb -> Get

#### [Subscribe Candidate in Job]
- Path -> '/jobs/subscribe'
- Verb -> Post

#### [Get by id and company id]
- Path -> '/jobs/<!id>/company/<!company_id>'
- Verb -> Get

## Restfull [Member]
- Class -> MemberEndpoint
- Path Prefix -> '/members'

#### [Create]
- Path -> '/members'
- Verb -> Post

#### [Delete]
- Path -> '/members'
- Verb -> Delete

#### [Get by Id]
- Path -> '/members/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/members'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/members/<!id>'
- Verb -> Put

## Restfull [Resume]
- Class -> ResumeEndpoint
- Path Prefix -> '/resumes'

#### [Create]
- Path -> '/resumes'
- Verb -> Post

#### [Delete]
- Path -> '/resumes'
- Verb -> Delete

#### [Get by Id]
- Path -> '/resumes/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/resumes'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/resumes/<!id>'
- Verb -> Put

#### [List with Candidates short]
- Path -> '/resumes/list_with_candidates_short'
- Verb -> Get
- Query -> start,max

#### [List with Candidates short paginated]
- Path -> '/resumes/list_with_candidates_short_paginated'
- Verb -> Get
- Query -> page,limit


## Restfull [Selective Process]
- Class -> SelectiveProcessEndpoint
- Path Prefix -> '/selectiveprocesses'

#### [Create]
- Path -> '/selectiveprocesses'
- Verb -> Post

#### [Delete]
- Path -> '/selectiveprocesses'
- Verb -> Delete

#### [Get by Id]
- Path -> '/selectiveprocesses/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/selectiveprocesses'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/selectiveprocesses/<!id>'
- Verb -> Put

#### [My Selective Processes] - Created by Company
- Path -> '/selectiveprocesses/my_selective_processes'
- Verb -> Get

#### [My Selective Processes Subscribed] - Selective Process where i have subscribed
- Path -> '/selectiveprocesses/my_selective_processes_subscribed'
- Verb -> Get

#### [Subscribe in Selective Processes] 
- Path -> '/selectiveprocesses/subscribe'
- Verb -> Post

#### [Get Paginated]
- Path -> '/selectiveprocesses/paginated'
- Verb -> Get
- Query -> page, limit

## Restfull
- Class -> StatisticsEndpoint
- Path Prefix -> '/statistics'

#### [List Stats] - List Stats
- Path -> '/statistics'
- Verb -> Get


## Restfull [Subscriber]
- Class -> SubscriberEndpoint
- Path Prefix -> '/subscribers'

#### [Create]
- Path -> '/subscribers'
- Verb -> Post

#### [Delete]
- Path -> '/subscribers'
- Verb -> Delete

#### [Get by Id]
- Path -> '/subscribers/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/subscribers'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/subscribers/<!id>'
- Verb -> Put

#### [Subscribe] = Toggle
- Path -> '/subscribers/subscribe'
- Verb -> Post

## Restfull [Testimonial]
- Class -> TestimonialEndpoint
- Path Prefix -> '/testimonials'

#### [Create]
- Path -> '/testimonials'
- Verb -> Post

#### [Delete]
- Path -> '/testimonials'
- Verb -> Delete

#### [Get by Id]
- Path -> '/testimonials/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/testimonials'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/testimonials/<!id>'
- Verb -> Put


## Restfull [User]
- Class -> UserEndpoint
- Path Prefix -> '/users'

#### [Create]
- Path -> '/users'
- Verb -> Post

#### [Delete]
- Path -> '/users'
- Verb -> Delete

#### [Get by Id]
- Path -> '/users/<!id>'
- Verb -> Get

#### [Get All]
- Path -> '/users'
- Verb -> Get
- Query -> start,max

#### [Update]
- Path -> '/users/<!id>'
- Verb -> Put






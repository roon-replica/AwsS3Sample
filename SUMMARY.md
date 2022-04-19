### Amazon Simple Storage Service
- S3 is storage over internet
- [S3 docs](https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html)
- object storage service?
  - simple structure: each bucket can store any number of objects 
  - object = file?, bucket = object의 container??
  
### TODO
- use AWS SDK for java 
- [x] create bucket 
- [x] delete bucket
- [x] download object
- [ ] upload
- [ ] copy, move, rename object

### steps
- 계정 만들고 IAM 사용자 만들기
- AWS SDK 의존성 설정, aws s3 연결 설정 등.. 
- API 사용해서 여러 조작 가능

### file upload in spring mvc
- spring offers multipart (file upload) support
  - MultipartResolver 객체
- 

### references
- https://www.baeldung.com/aws-s3-java 
- https://www.baeldung.com/spring-file-upload
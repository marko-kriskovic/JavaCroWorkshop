# Java Cro Workshop

## Preparation:
1. Register into [Bytechef](https://app.bytechef.io/)
2. Fork this repository
 
## [Workflow](https://github.com/marko-kriskovic/JavaCroWorkshop/blob/main/bytechef-workflows/workshop/task1.json) for handing out material links:
1. Create a new Project
2. Create a new Workflow
3. Change the trigger (first node) into Infobip component; select newWhatsappMessage trigger
<img width="297" height="161" alt="image" src="https://github.com/user-attachments/assets/a9f87a03-8d55-4b29-ac59-615bcd121319" />

4. Add a new OpenAi action by clicking the '+'; select Ask action
5. Make an [OpenAi](https://platform.openai.com/settings/organization/api-keys) connection
<img width="526" height="316" alt="image" src="https://github.com/user-attachments/assets/6cc69732-60f4-443e-b200-4f50a02d8554" />

6. Add Agile CRM, select createContact action
7. Here are the credentials:
- domain: bytechef
- email: connector-dev@bytechef.io
- REST API Key: t6cbv1vc4g8s1lrk923ksk7p22
8. Add a new Logger component; Info action
9. Fill in all the Properties:
  
 a. Simulate an output instead of the connection (click the Upload Sample Output Data and paste [this](https://github.com/marko-kriskovic/JavaCroWorkshop/blob/main/bytechef-workflows/output/infobip.json))
 
<img width="520" height="530" alt="image" src="https://github.com/user-attachments/assets/f01cc193-ae0f-4995-89e6-7a95433f350e" />

 b. Create an input instead of the connection
 
<img width="273" height="278" alt="image" src="https://github.com/user-attachments/assets/277d01aa-2e86-462b-8fad-934fe74d0eaf" />

10. Publish the Project
<img width="565" height="303" alt="image" src="https://github.com/user-attachments/assets/6f71812d-c1b9-4438-8eff-1dd9761c9368" />

11. Deploy it
<img width="187" height="236" alt="image" src="https://github.com/user-attachments/assets/5653c71a-1895-4d93-99cd-2a8f98d9b5b7" />
<img width="501" height="257" alt="image" src="https://github.com/user-attachments/assets/c6138e57-89e6-4804-8822-3267923563dd" />

12. Run the workflow
<img width="409" height="225" alt="image" src="https://github.com/user-attachments/assets/15372620-6cd5-4474-aa32-dfd16ffed678" />

## [Workflow](https://github.com/marko-kriskovic/JavaCroWorkshop/blob/main/bytechef-workflows/workshop/task2.json) for solving easy Github issues
1. Create a new Workflow in the same Project
<img width="596" height="185" alt="image" src="https://github.com/user-attachments/assets/4382016f-80c3-4d19-92cc-365289246211" />

2. Change the trigger to Github; newPullRequest
3. Make a [GitHub](https://docs.bytechef.io/reference/components/github) connection
4. Add a new OpenAi; Ask action
5. Add a Condition Flow
<img width="374" height="473" alt="image" src="https://github.com/user-attachments/assets/8da9b402-e069-400e-a7d3-5b485d7bdddf" />

6. Add GitHub addLabelsToIssue action on the left and Claude Code chat action on the right
7. Fill in all the Properties
8. Publish the Project
9. Deploy it

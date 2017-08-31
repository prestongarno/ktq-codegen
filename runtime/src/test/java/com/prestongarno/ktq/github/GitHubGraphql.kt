@file:Suppress("unused")

package com.prestongarno.ktq.github

import com.prestongarno.ktq.*

abstract class BaseAvatarUrlArgs(args: ArgBuilder = ArgBuilder.create<URI, BaseAvatarUrlArgs>()) : ArgBuilder by args

data class AcceptTopicSuggestionInput(private val repositoryId: String,
    private val name: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object AcceptTopicSuggestionPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val topic: InitStub<Topic> by lazy { typeStub<Topic>() }
}

interface Actor : QSchemaType {
  val avatarUrl: QConfigStub<URI, BaseAvatarUrlArgs>

  val login: Stub<String>

  val resourcePath: Stub<URI>

  val url: Stub<URI>
}

data class AddCommentInput(private val subjectId: String, private val body: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object AddCommentPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val commentEdge: InitStub<IssueCommentEdge> by lazy { typeStub<IssueCommentEdge>() }

  val subject: InitStub<Node> by lazy { typeStub<Node>() }

  val timelineEdge: InitStub<IssueTimelineItemEdge> by lazy { typeStub<IssueTimelineItemEdge>() }
}

data class AddProjectCardInput(private val projectColumnId: String) : QInput {
  private var clientMutationId: String? = null
  private var contentId: String? = null
  private var note: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun contentId(model: String) = apply { contentId = model }

  fun note(model: String) = apply { note = model }
}

object AddProjectCardPayload : QSchemaType {
  val cardEdge: InitStub<ProjectCardEdge> by lazy { typeStub<ProjectCardEdge>() }

  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val projectColumn: InitStub<Project> by lazy { typeStub<Project>() }
}

data class AddProjectColumnInput(private val projectId: String, private val name: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object AddProjectColumnPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val columnEdge: InitStub<ProjectColumnEdge> by lazy { typeStub<ProjectColumnEdge>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }
}

data class AddPullRequestReviewCommentInput(private val pullRequestReviewId: String,
    private val body: String) : QInput {
  private var clientMutationId: String? = null
  private var commitOID: GitObjectID? = null
  private var path: String? = null
  private var position: Int? = null
  private var inReplyTo: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun commitOID(model: GitObjectID) = apply { commitOID = model }

  fun path(model: String) = apply { path = model }

  fun position(model: Int) = apply { position = model }

  fun inReplyTo(model: String) = apply { inReplyTo = model }
}

object AddPullRequestReviewCommentPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val comment: InitStub<PullRequestReviewComment> by lazy { typeStub<PullRequestReviewComment>() }

  val commentEdge: InitStub<PullRequestReviewCommentEdge> by lazy { typeStub<PullRequestReviewCommentEdge>() }
}

data class AddPullRequestReviewInput(private val pullRequestId: String) : QInput {
  private var clientMutationId: String? = null
  private var commitOID: GitObjectID? = null
  private var body: String? = null
  private var event: PullRequestReviewEvent? = null
  private var comments: DraftPullRequestReviewComment? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun commitOID(model: GitObjectID) = apply { commitOID = model }

  fun body(model: String) = apply { body = model }

  fun event(model: PullRequestReviewEvent) = apply { event = model }

  fun comments(model: DraftPullRequestReviewComment) = apply { comments = model }
}

object AddPullRequestReviewPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }

  val reviewEdge: InitStub<PullRequestReviewEdge> by lazy { typeStub<PullRequestReviewEdge>() }
}

data class AddReactionInput(private val subjectId: String,
    private val content: ReactionContent) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object AddReactionPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val reaction: InitStub<Reaction> by lazy { typeStub<Reaction>() }

  val subject: InitStub<Reactable> by lazy { typeStub<Reactable>() }
}

data class AddStarInput(private val starrableId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object AddStarPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val starrable: InitStub<Starrable> by lazy { typeStub<Starrable>() }
}

object AddedToProjectEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

interface Assignable : QSchemaType {
  val assignees: QTypeConfigStub<UserConnection, AssigneesArgs>

  class AssigneesArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, AssigneesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): AssigneesArgs = apply { addArg("first", value) }


    fun after(value: String): AssigneesArgs = apply { addArg("after", value) }


    fun last(value: Int): AssigneesArgs = apply { addArg("last", value) }


    fun before(value: String): AssigneesArgs = apply { addArg("before", value) }

  }
}

object AssignedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val assignable: InitStub<Assignable> by lazy { typeStub<Assignable>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val user: InitStub<User> by lazy { typeStub<User>() }
}

object BaseRefChangedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object BaseRefForcePushedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val afterCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val beforeCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val ref: InitStub<Ref> by lazy { typeStub<Ref>() }
}

object Blame : QSchemaType {
  val ranges: InitStub<BlameRange> by lazy { typeStub<BlameRange>() }
}

object BlameRange : QSchemaType {
  val age: Stub<Int> by lazy { stub<Int>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val endingLine: Stub<Int> by lazy { stub<Int>() }

  val startingLine: Stub<Int> by lazy { stub<Int>() }
}

object Blob : QSchemaType, GitObject, Node {
  override val abbreviatedOid: Stub<String> by lazy { stub<String>() }

  val byteSize: Stub<Int> by lazy { stub<Int>() }

  override val commitResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val commitUrl: Stub<URI> by lazy { stub<URI>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isBinary: Stub<Boolean> by lazy { stub<Boolean>() }

  val isTruncated: Stub<Boolean> by lazy { stub<Boolean>() }

  override val oid: Stub<GitObjectID> by lazy { stub<GitObjectID>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val text: Stub<String> by lazy { stub<String>() }
}

object Bot : QSchemaType, UniformResourceLocatable, Actor, Node {
  override val avatarUrl: QConfigStub<URI, AvatarUrlArgs> by lazy { configStub<URI, AvatarUrlArgs>(AvatarUrlArgs()) }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val login: Stub<String> by lazy { stub<String>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  class AvatarUrlArgs(args: ArgBuilder = ArgBuilder.create<URI, AvatarUrlArgs>()) : BaseAvatarUrlArgs(args) {
    fun size(value: Int): AvatarUrlArgs = apply { addArg("size", value) }

  }
}

interface Closable : QSchemaType {
  val closed: Stub<Boolean>
}

object ClosedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val closable: InitStub<Closable> by lazy { typeStub<Closable>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object CodeOfConduct : QSchemaType {
  val body: Stub<String> by lazy { stub<String>() }

  val key: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val url: Stub<URI> by lazy { stub<URI>() }
}

interface Comment : QSchemaType {
  val author: InitStub<Actor>

  val authorAssociation: Stub<CommentAuthorAssociation>

  val body: Stub<String>

  val bodyHTML: Stub<HTML>

  val createdAt: Stub<DateTime>

  val createdViaEmail: Stub<Boolean>

  val editor: InitStub<Actor>

  val id: Stub<String>

  val lastEditedAt: Stub<DateTime>

  val publishedAt: Stub<DateTime>

  val updatedAt: Stub<DateTime>

  val viewerDidAuthor: Stub<Boolean>
}

enum class CommentAuthorAssociation : QSchemaType {
  MEMBER,

  OWNER,

  COLLABORATOR,

  CONTRIBUTOR,

  FIRST_TIME_CONTRIBUTOR,

  NONE
}

enum class CommentCannotUpdateReason : QSchemaType {
  INSUFFICIENT_ACCESS,

  LOCKED,

  LOGIN_REQUIRED,

  MAINTENANCE,

  VERIFIED_EMAIL_REQUIRED
}

object CommentDeletedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object Commit : QSchemaType, Subscribable, GitObject, Node {
  override val abbreviatedOid: Stub<String> by lazy { stub<String>() }

  val author: InitStub<GitActor> by lazy { typeStub<GitActor>() }

  val authoredByCommitter: Stub<Boolean> by lazy { stub<Boolean>() }

  val blame: QTypeConfigStub<Blame, BlameArgs> by lazy { typeConfigStub<Blame, BlameArgs>(BlameArgs()) }

  val comments: QTypeConfigStub<CommitCommentConnection, CommentsArgs> by lazy { typeConfigStub<CommitCommentConnection, CommentsArgs>(CommentsArgs()) }

  override val commitResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val commitUrl: Stub<URI> by lazy { stub<URI>() }

  val committedDate: Stub<DateTime> by lazy { stub<DateTime>() }

  val committedViaWeb: Stub<Boolean> by lazy { stub<Boolean>() }

  val committer: InitStub<GitActor> by lazy { typeStub<GitActor>() }

  val history: QTypeConfigStub<CommitHistoryConnection, HistoryArgs> by lazy { typeConfigStub<CommitHistoryConnection, HistoryArgs>(HistoryArgs()) }

  override val id: Stub<String> by lazy { stub<String>() }

  val message: Stub<String> by lazy { stub<String>() }

  val messageBody: Stub<String> by lazy { stub<String>() }

  val messageBodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val messageHeadline: Stub<String> by lazy { stub<String>() }

  val messageHeadlineHTML: Stub<HTML> by lazy { stub<HTML>() }

  override val oid: Stub<GitObjectID> by lazy { stub<GitObjectID>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val signature: InitStub<GitSignature> by lazy { typeStub<GitSignature>() }

  val status: InitStub<Status> by lazy { typeStub<Status>() }

  val tree: InitStub<Tree> by lazy { typeStub<Tree>() }

  val treeResourcePath: Stub<URI> by lazy { stub<URI>() }

  val treeUrl: Stub<URI> by lazy { stub<URI>() }

  val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanSubscribe: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerSubscription: Stub<SubscriptionState> by lazy { stub<SubscriptionState>() }

  class BlameArgs(args: TypeArgBuilder = TypeArgBuilder.create<Blame, BlameArgs>()) : TypeArgBuilder by args {
    fun path(value: String): BlameArgs = apply { addArg("path", value) }

  }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<CommitCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }

  class HistoryArgs(args: TypeArgBuilder = TypeArgBuilder.create<CommitHistoryConnection, HistoryArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): HistoryArgs = apply { addArg("first", value) }


    fun after(value: String): HistoryArgs = apply { addArg("after", value) }


    fun last(value: Int): HistoryArgs = apply { addArg("last", value) }


    fun before(value: String): HistoryArgs = apply { addArg("before", value) }


    fun path(value: String): HistoryArgs = apply { addArg("path", value) }


    fun author(value: CommitAuthor): HistoryArgs = apply { addArg("author", value) }


    fun since(value: GitTimestamp): HistoryArgs = apply { addArg("since", value) }


    fun until(value: GitTimestamp): HistoryArgs = apply { addArg("until", value) }

  }
}

data class CommitAuthor(private val emails: String) : QInput {
  private var id: String? = null
  fun id(model: String) = apply { id = model }
}

object CommitComment : QSchemaType, RepositoryNode, Reactable, UpdatableComment, Updatable, Deletable, Comment, Node {
  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val path: Stub<String> by lazy { stub<String>() }

  val position: Stub<Int> by lazy { stub<Int>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val reactionGroups: InitStub<ReactionGroup> by lazy { typeStub<ReactionGroup>() }

  override val reactions: QTypeConfigStub<ReactionConnection, Reactable.ReactionsArgs> by lazy { typeConfigStub<ReactionConnection, Reactable.ReactionsArgs>(Reactable.ReactionsArgs()) }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val viewerCanDelete: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanReact: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }
}

object CommitCommentConnection : QSchemaType {
  val edges: InitStub<CommitCommentEdge> by lazy { typeStub<CommitCommentEdge>() }

  val nodes: InitStub<CommitComment> by lazy { typeStub<CommitComment>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object CommitCommentEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<CommitComment> by lazy { typeStub<CommitComment>() }
}

object CommitCommentThread : QSchemaType, RepositoryNode, Node {
  val comments: QTypeConfigStub<CommitCommentConnection, CommentsArgs> by lazy { typeConfigStub<CommitCommentConnection, CommentsArgs>(CommentsArgs()) }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val path: Stub<String> by lazy { stub<String>() }

  val position: Stub<Int> by lazy { stub<Int>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<CommitCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }
}

object CommitEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Commit> by lazy { typeStub<Commit>() }
}

object CommitHistoryConnection : QSchemaType {
  val edges: InitStub<CommitEdge> by lazy { typeStub<CommitEdge>() }

  val nodes: InitStub<Commit> by lazy { typeStub<Commit>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }
}

object ConvertedNoteToIssueEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

data class CreateProjectInput(private val ownerId: String, private val name: String) : QInput {
  private var clientMutationId: String? = null
  private var body: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun body(model: String) = apply { body = model }
}

object CreateProjectPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }
}

object DateTime : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

data class DeclineTopicSuggestionInput(private val repositoryId: String, private val name: String,
    private val reason: TopicSuggestionDeclineReason) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DeclineTopicSuggestionPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val topic: InitStub<Topic> by lazy { typeStub<Topic>() }
}

enum class DefaultRepositoryPermissionField : QSchemaType {
  READ,

  WRITE,

  ADMIN
}

interface Deletable : QSchemaType {
  val viewerCanDelete: Stub<Boolean>
}

data class DeleteProjectCardInput(private val cardId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DeleteProjectCardPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val column: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }

  val deletedCardId: Stub<String> by lazy { stub<String>() }
}

data class DeleteProjectColumnInput(private val columnId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DeleteProjectColumnPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val deletedColumnId: Stub<String> by lazy { stub<String>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }
}

data class DeleteProjectInput(private val projectId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DeleteProjectPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val owner: InitStub<ProjectOwner> by lazy { typeStub<ProjectOwner>() }
}

data class DeletePullRequestReviewInput(private val pullRequestReviewId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DeletePullRequestReviewPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }
}

object DemilestonedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val milestoneTitle: Stub<String> by lazy { stub<String>() }

  val subject: InitStub<MilestoneItem> by lazy { typeStub<MilestoneItem>() }
}

object DeployedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  val deployment: InitStub<Deployment> by lazy { typeStub<Deployment>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val ref: InitStub<Ref> by lazy { typeStub<Ref>() }
}

object Deployment : QSchemaType, Node {
  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val environment: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val latestStatus: InitStub<DeploymentStatus> by lazy { typeStub<DeploymentStatus>() }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val state: Stub<DeploymentState> by lazy { stub<DeploymentState>() }

  val statuses: QTypeConfigStub<DeploymentStatusConnection, StatusesArgs> by lazy { typeConfigStub<DeploymentStatusConnection, StatusesArgs>(StatusesArgs()) }

  class StatusesArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeploymentStatusConnection, StatusesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): StatusesArgs = apply { addArg("first", value) }


    fun after(value: String): StatusesArgs = apply { addArg("after", value) }


    fun last(value: Int): StatusesArgs = apply { addArg("last", value) }


    fun before(value: String): StatusesArgs = apply { addArg("before", value) }

  }
}

object DeploymentConnection : QSchemaType {
  val edges: InitStub<DeploymentEdge> by lazy { typeStub<DeploymentEdge>() }

  val nodes: InitStub<Deployment> by lazy { typeStub<Deployment>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object DeploymentEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Deployment> by lazy { typeStub<Deployment>() }
}

enum class DeploymentState : QSchemaType {
  ABANDONED,

  ACTIVE,

  DESTROYED,

  ERROR,

  FAILURE,

  INACTIVE,

  PENDING
}

object DeploymentStatus : QSchemaType, Node {
  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val deployment: InitStub<Deployment> by lazy { typeStub<Deployment>() }

  val description: Stub<String> by lazy { stub<String>() }

  val environmentUrl: Stub<URI> by lazy { stub<URI>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val logUrl: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<DeploymentStatusState> by lazy { stub<DeploymentStatusState>() }
}

object DeploymentStatusConnection : QSchemaType {
  val edges: InitStub<DeploymentStatusEdge> by lazy { typeStub<DeploymentStatusEdge>() }

  val nodes: InitStub<DeploymentStatus> by lazy { typeStub<DeploymentStatus>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object DeploymentStatusEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<DeploymentStatus> by lazy { typeStub<DeploymentStatus>() }
}

enum class DeploymentStatusState : QSchemaType {
  PENDING,

  SUCCESS,

  FAILURE,

  INACTIVE,

  ERROR
}

data class DismissPullRequestReviewInput(private val pullRequestReviewId: String,
    private val message: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object DismissPullRequestReviewPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }
}

data class DraftPullRequestReviewComment(private val path: String, private val position: Int,
    private val body: String) : QInput

object ExternalIdentity : QSchemaType, Node {
  val guid: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val organizationInvitation: InitStub<OrganizationInvitation> by lazy { typeStub<OrganizationInvitation>() }

  val samlIdentity: InitStub<ExternalIdentitySamlAttributes> by lazy { typeStub<ExternalIdentitySamlAttributes>() }

  val scimIdentity: InitStub<ExternalIdentityScimAttributes> by lazy { typeStub<ExternalIdentityScimAttributes>() }

  val user: InitStub<User> by lazy { typeStub<User>() }
}

object ExternalIdentityConnection : QSchemaType {
  val edges: InitStub<ExternalIdentityEdge> by lazy { typeStub<ExternalIdentityEdge>() }

  val nodes: InitStub<ExternalIdentity> by lazy { typeStub<ExternalIdentity>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ExternalIdentityEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ExternalIdentity> by lazy { typeStub<ExternalIdentity>() }
}

object ExternalIdentitySamlAttributes : QSchemaType {
  val nameId: Stub<String> by lazy { stub<String>() }
}

object ExternalIdentityScimAttributes : QSchemaType {
  val username: Stub<String> by lazy { stub<String>() }
}

object FollowerConnection : QSchemaType {
  val edges: InitStub<UserEdge> by lazy { typeStub<UserEdge>() }

  val nodes: InitStub<User> by lazy { typeStub<User>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object FollowingConnection : QSchemaType {
  val edges: InitStub<UserEdge> by lazy { typeStub<UserEdge>() }

  val nodes: InitStub<User> by lazy { typeStub<User>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object Gist : QSchemaType, Starrable, Node {
  val comments: QTypeConfigStub<GistCommentConnection, CommentsArgs> by lazy { typeConfigStub<GistCommentConnection, CommentsArgs>(CommentsArgs()) }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val description: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isPublic: Stub<Boolean> by lazy { stub<Boolean>() }

  val name: Stub<String> by lazy { stub<String>() }

  val owner: InitStub<RepositoryOwner> by lazy { typeStub<RepositoryOwner>() }

  override val stargazers: QTypeConfigStub<StargazerConnection, Starrable.StargazersArgs> by lazy { typeConfigStub<StargazerConnection, Starrable.StargazersArgs>(Starrable.StargazersArgs()) }

  val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val viewerHasStarred: Stub<Boolean> by lazy { stub<Boolean>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<GistCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }
}

object GistComment : QSchemaType, UpdatableComment, Updatable, Deletable, Comment, Node {
  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val viewerCanDelete: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }
}

object GistCommentConnection : QSchemaType {
  val edges: InitStub<GistCommentEdge> by lazy { typeStub<GistCommentEdge>() }

  val nodes: InitStub<GistComment> by lazy { typeStub<GistComment>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object GistCommentEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<GistComment> by lazy { typeStub<GistComment>() }
}

object GistConnection : QSchemaType {
  val edges: InitStub<GistEdge> by lazy { typeStub<GistEdge>() }

  val nodes: InitStub<Gist> by lazy { typeStub<Gist>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object GistEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Gist> by lazy { typeStub<Gist>() }
}

enum class GistPrivacy : QSchemaType {
  PUBLIC,

  SECRET,

  ALL
}

object GitActor : QSchemaType {
  val avatarUrl: QConfigStub<URI, AvatarUrlArgs> by lazy { configStub<URI, AvatarUrlArgs>(AvatarUrlArgs()) }

  val date: Stub<GitTimestamp> by lazy { stub<GitTimestamp>() }

  val email: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val user: InitStub<User> by lazy { typeStub<User>() }

  class AvatarUrlArgs(args: ArgBuilder = ArgBuilder.create<URI, AvatarUrlArgs>()) : ArgBuilder by args {
    fun size(value: Int): AvatarUrlArgs = apply { addArg("size", value) }

  }
}

interface GitObject : QSchemaType {
  val abbreviatedOid: Stub<String>

  val commitResourcePath: Stub<URI>

  val commitUrl: Stub<URI>

  val id: Stub<String>

  val oid: Stub<GitObjectID>

  val repository: InitStub<Repository>
}

object GitObjectID : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

interface GitSignature : QSchemaType {
  val email: Stub<String>

  val isValid: Stub<Boolean>

  val payload: Stub<String>

  val signature: Stub<String>

  val signer: InitStub<User>

  val state: Stub<GitSignatureState>
}

enum class GitSignatureState : QSchemaType {
  VALID,

  INVALID,

  MALFORMED_SIG,

  UNKNOWN_KEY,

  BAD_EMAIL,

  UNVERIFIED_EMAIL,

  NO_USER,

  UNKNOWN_SIG_TYPE,

  UNSIGNED,

  GPGVERIFY_UNAVAILABLE,

  GPGVERIFY_ERROR,

  NOT_SIGNING_KEY,

  EXPIRED_KEY
}

object GitTimestamp : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

object GpgSignature : QSchemaType, GitSignature {
  override val email: Stub<String> by lazy { stub<String>() }

  override val isValid: Stub<Boolean> by lazy { stub<Boolean>() }

  val keyId: Stub<String> by lazy { stub<String>() }

  override val payload: Stub<String> by lazy { stub<String>() }

  override val signature: Stub<String> by lazy { stub<String>() }

  override val signer: InitStub<User> by lazy { typeStub<User>() }

  override val state: Stub<GitSignatureState> by lazy { stub<GitSignatureState>() }
}

object HTML : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

object HeadRefDeletedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val headRef: InitStub<Ref> by lazy { typeStub<Ref>() }

  val headRefName: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

object HeadRefForcePushedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val afterCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val beforeCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val ref: InitStub<Ref> by lazy { typeStub<Ref>() }
}

object HeadRefRestoredEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

object Issue : QSchemaType, UniformResourceLocatable, Subscribable, RepositoryNode, Reactable, Lockable, Labelable, UpdatableComment, Updatable, Comment, Closable, Assignable, Node {
  override val assignees: QTypeConfigStub<UserConnection, Assignable.AssigneesArgs> by lazy { typeConfigStub<UserConnection, Assignable.AssigneesArgs>(Assignable.AssigneesArgs()) }

  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val bodyText: Stub<String> by lazy { stub<String>() }

  override val closed: Stub<Boolean> by lazy { stub<Boolean>() }

  val comments: QTypeConfigStub<IssueCommentConnection, CommentsArgs> by lazy { typeConfigStub<IssueCommentConnection, CommentsArgs>(CommentsArgs()) }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val labels: QTypeConfigStub<LabelConnection, Labelable.LabelsArgs> by lazy { typeConfigStub<LabelConnection, Labelable.LabelsArgs>(Labelable.LabelsArgs()) }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val locked: Stub<Boolean> by lazy { stub<Boolean>() }

  val milestone: InitStub<Milestone> by lazy { typeStub<Milestone>() }

  val number: Stub<Int> by lazy { stub<Int>() }

  val participants: QTypeConfigStub<UserConnection, ParticipantsArgs> by lazy { typeConfigStub<UserConnection, ParticipantsArgs>(ParticipantsArgs()) }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val reactionGroups: InitStub<ReactionGroup> by lazy { typeStub<ReactionGroup>() }

  override val reactions: QTypeConfigStub<ReactionConnection, Reactable.ReactionsArgs> by lazy { typeConfigStub<ReactionConnection, Reactable.ReactionsArgs>(Reactable.ReactionsArgs()) }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<IssueState> by lazy { stub<IssueState>() }

  val timeline: QTypeConfigStub<IssueTimelineConnection, TimelineArgs> by lazy { typeConfigStub<IssueTimelineConnection, TimelineArgs>(TimelineArgs()) }

  val title: Stub<String> by lazy { stub<String>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanReact: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanSubscribe: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerSubscription: Stub<SubscriptionState> by lazy { stub<SubscriptionState>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }

  class ParticipantsArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, ParticipantsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ParticipantsArgs = apply { addArg("first", value) }


    fun after(value: String): ParticipantsArgs = apply { addArg("after", value) }


    fun last(value: Int): ParticipantsArgs = apply { addArg("last", value) }


    fun before(value: String): ParticipantsArgs = apply { addArg("before", value) }

  }

  class TimelineArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueTimelineConnection, TimelineArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): TimelineArgs = apply { addArg("first", value) }


    fun after(value: String): TimelineArgs = apply { addArg("after", value) }


    fun last(value: Int): TimelineArgs = apply { addArg("last", value) }


    fun before(value: String): TimelineArgs = apply { addArg("before", value) }


    fun since(value: DateTime): TimelineArgs = apply { addArg("since", value) }

  }
}

object IssueComment : QSchemaType, RepositoryNode, Reactable, UpdatableComment, Updatable, Deletable, Comment, Node {
  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val bodyText: Stub<String> by lazy { stub<String>() }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val reactionGroups: InitStub<ReactionGroup> by lazy { typeStub<ReactionGroup>() }

  override val reactions: QTypeConfigStub<ReactionConnection, Reactable.ReactionsArgs> by lazy { typeConfigStub<ReactionConnection, Reactable.ReactionsArgs>(Reactable.ReactionsArgs()) }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val viewerCanDelete: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanReact: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }
}

object IssueCommentConnection : QSchemaType {
  val edges: InitStub<IssueCommentEdge> by lazy { typeStub<IssueCommentEdge>() }

  val nodes: InitStub<IssueComment> by lazy { typeStub<IssueComment>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object IssueCommentEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<IssueComment> by lazy { typeStub<IssueComment>() }
}

object IssueConnection : QSchemaType {
  val edges: InitStub<IssueEdge> by lazy { typeStub<IssueEdge>() }

  val nodes: InitStub<Issue> by lazy { typeStub<Issue>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object IssueEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Issue> by lazy { typeStub<Issue>() }
}

object IssueOrPullRequest : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

data class IssueOrder(private val field: IssueOrderField,
    private val direction: OrderDirection) : QInput

enum class IssueOrderField : QSchemaType {
  CREATED_AT,

  UPDATED_AT,

  COMMENTS
}

enum class IssuePubSubTopic : QSchemaType {
  UPDATED,

  MARKASREAD
}

enum class IssueState : QSchemaType {
  OPEN,

  CLOSED
}

object IssueTimelineConnection : QSchemaType {
  val edges: InitStub<IssueTimelineItemEdge> by lazy { typeStub<IssueTimelineItemEdge>() }

  val nodes: InitStub<IssueTimelineItem> by lazy { typeStub<IssueTimelineItem>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object IssueTimelineItem : QSchemaType {
  val Commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val IssueComment: InitStub<IssueComment> by lazy { typeStub<IssueComment>() }

  val ClosedEvent: InitStub<ClosedEvent> by lazy { typeStub<ClosedEvent>() }

  val ReopenedEvent: InitStub<ReopenedEvent> by lazy { typeStub<ReopenedEvent>() }

  val SubscribedEvent: InitStub<SubscribedEvent> by lazy { typeStub<SubscribedEvent>() }

  val UnsubscribedEvent: InitStub<UnsubscribedEvent> by lazy { typeStub<UnsubscribedEvent>() }

  val ReferencedEvent: InitStub<ReferencedEvent> by lazy { typeStub<ReferencedEvent>() }

  val AssignedEvent: InitStub<AssignedEvent> by lazy { typeStub<AssignedEvent>() }

  val UnassignedEvent: InitStub<UnassignedEvent> by lazy { typeStub<UnassignedEvent>() }

  val LabeledEvent: InitStub<LabeledEvent> by lazy { typeStub<LabeledEvent>() }

  val UnlabeledEvent: InitStub<UnlabeledEvent> by lazy { typeStub<UnlabeledEvent>() }

  val MilestonedEvent: InitStub<MilestonedEvent> by lazy { typeStub<MilestonedEvent>() }

  val DemilestonedEvent: InitStub<DemilestonedEvent> by lazy { typeStub<DemilestonedEvent>() }

  val RenamedTitleEvent: InitStub<RenamedTitleEvent> by lazy { typeStub<RenamedTitleEvent>() }

  val LockedEvent: InitStub<LockedEvent> by lazy { typeStub<LockedEvent>() }

  val UnlockedEvent: InitStub<UnlockedEvent> by lazy { typeStub<UnlockedEvent>() }
}

object IssueTimelineItemEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<IssueTimelineItem> by lazy { typeStub<IssueTimelineItem>() }
}

object Label : QSchemaType, Node {
  val color: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val issues: QTypeConfigStub<IssueConnection, IssuesArgs> by lazy { typeConfigStub<IssueConnection, IssuesArgs>(IssuesArgs()) }

  val name: Stub<String> by lazy { stub<String>() }

  val pullRequests: QTypeConfigStub<PullRequestConnection, PullRequestsArgs> by lazy { typeConfigStub<PullRequestConnection, PullRequestsArgs>(PullRequestsArgs()) }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  class IssuesArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueConnection, IssuesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): IssuesArgs = apply { addArg("first", value) }


    fun after(value: String): IssuesArgs = apply { addArg("after", value) }


    fun last(value: Int): IssuesArgs = apply { addArg("last", value) }


    fun before(value: String): IssuesArgs = apply { addArg("before", value) }


    fun labels(value: String): IssuesArgs = apply { addArg("labels", value) }


    fun orderBy(value: IssueOrder): IssuesArgs = apply { addArg("orderBy", value) }


    fun states(value: IssueState): IssuesArgs = apply { addArg("states", value) }

  }

  class PullRequestsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestConnection, PullRequestsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): PullRequestsArgs = apply { addArg("first", value) }


    fun after(value: String): PullRequestsArgs = apply { addArg("after", value) }


    fun last(value: Int): PullRequestsArgs = apply { addArg("last", value) }


    fun before(value: String): PullRequestsArgs = apply { addArg("before", value) }

  }
}

object LabelConnection : QSchemaType {
  val edges: InitStub<LabelEdge> by lazy { typeStub<LabelEdge>() }

  val nodes: InitStub<Label> by lazy { typeStub<Label>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object LabelEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Label> by lazy { typeStub<Label>() }
}

interface Labelable : QSchemaType {
  val labels: QTypeConfigStub<LabelConnection, LabelsArgs>

  class LabelsArgs(args: TypeArgBuilder = TypeArgBuilder.create<LabelConnection, LabelsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): LabelsArgs = apply { addArg("first", value) }


    fun after(value: String): LabelsArgs = apply { addArg("after", value) }


    fun last(value: Int): LabelsArgs = apply { addArg("last", value) }


    fun before(value: String): LabelsArgs = apply { addArg("before", value) }

  }
}

object LabeledEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val label: InitStub<Label> by lazy { typeStub<Label>() }

  val labelable: InitStub<Labelable> by lazy { typeStub<Labelable>() }
}

object Language : QSchemaType, Node {
  val color: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }
}

object LanguageConnection : QSchemaType {
  val edges: InitStub<LanguageEdge> by lazy { typeStub<LanguageEdge>() }

  val nodes: InitStub<Language> by lazy { typeStub<Language>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }

  val totalSize: Stub<Int> by lazy { stub<Int>() }
}

object LanguageEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Language> by lazy { typeStub<Language>() }

  val size: Stub<Int> by lazy { stub<Int>() }
}

data class LanguageOrder(private val field: LanguageOrderField,
    private val direction: OrderDirection) : QInput

enum class LanguageOrderField : QSchemaType {
  SIZE
}

interface Lockable : QSchemaType {
  val locked: Stub<Boolean>
}

object LockedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val lockable: InitStub<Lockable> by lazy { typeStub<Lockable>() }
}

object MentionedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

enum class MergeableState : QSchemaType {
  MERGEABLE,

  CONFLICTING,

  UNKNOWN
}

object MergedEvent : QSchemaType, UniformResourceLocatable, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val mergeRef: InitStub<Ref> by lazy { typeStub<Ref>() }

  val mergeRefName: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

object Milestone : QSchemaType, UniformResourceLocatable, Node {
  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val description: Stub<String> by lazy { stub<String>() }

  val dueOn: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val number: Stub<Int> by lazy { stub<Int>() }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<MilestoneState> by lazy { stub<MilestoneState>() }

  val title: Stub<String> by lazy { stub<String>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

object MilestoneConnection : QSchemaType {
  val edges: InitStub<MilestoneEdge> by lazy { typeStub<MilestoneEdge>() }

  val nodes: InitStub<Milestone> by lazy { typeStub<Milestone>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object MilestoneEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Milestone> by lazy { typeStub<Milestone>() }
}

object MilestoneItem : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

enum class MilestoneState : QSchemaType {
  OPEN,

  CLOSED
}

object MilestonedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val milestoneTitle: Stub<String> by lazy { stub<String>() }

  val subject: InitStub<MilestoneItem> by lazy { typeStub<MilestoneItem>() }
}

data class MoveProjectCardInput(private val cardId: String, private val columnId: String) : QInput {
  private var clientMutationId: String? = null
  private var afterCardId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun afterCardId(model: String) = apply { afterCardId = model }
}

object MoveProjectCardPayload : QSchemaType {
  val cardEdge: InitStub<ProjectCardEdge> by lazy { typeStub<ProjectCardEdge>() }

  val clientMutationId: Stub<String> by lazy { stub<String>() }
}

data class MoveProjectColumnInput(private val columnId: String) : QInput {
  private var clientMutationId: String? = null
  private var afterColumnId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun afterColumnId(model: String) = apply { afterColumnId = model }
}

object MoveProjectColumnPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val columnEdge: InitStub<ProjectColumnEdge> by lazy { typeStub<ProjectColumnEdge>() }
}

object MovedColumnsInProjectEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object Mutation : QSchemaType {
  val acceptTopicSuggestion: QTypeConfigStub<AcceptTopicSuggestionPayload, AcceptTopicSuggestionArgs> by lazy { typeConfigStub<AcceptTopicSuggestionPayload, AcceptTopicSuggestionArgs>(AcceptTopicSuggestionArgs()) }

  val addComment: QTypeConfigStub<AddCommentPayload, AddCommentArgs> by lazy { typeConfigStub<AddCommentPayload, AddCommentArgs>(AddCommentArgs()) }

  val addProjectCard: QTypeConfigStub<AddProjectCardPayload, AddProjectCardArgs> by lazy { typeConfigStub<AddProjectCardPayload, AddProjectCardArgs>(AddProjectCardArgs()) }

  val addProjectColumn: QTypeConfigStub<AddProjectColumnPayload, AddProjectColumnArgs> by lazy { typeConfigStub<AddProjectColumnPayload, AddProjectColumnArgs>(AddProjectColumnArgs()) }

  val addPullRequestReview: QTypeConfigStub<AddPullRequestReviewPayload, AddPullRequestReviewArgs> by lazy { typeConfigStub<AddPullRequestReviewPayload, AddPullRequestReviewArgs>(AddPullRequestReviewArgs()) }

  val addPullRequestReviewComment: QTypeConfigStub<AddPullRequestReviewCommentPayload, AddPullRequestReviewCommentArgs> by lazy { typeConfigStub<AddPullRequestReviewCommentPayload, AddPullRequestReviewCommentArgs>(AddPullRequestReviewCommentArgs()) }

  val addReaction: QTypeConfigStub<AddReactionPayload, AddReactionArgs> by lazy { typeConfigStub<AddReactionPayload, AddReactionArgs>(AddReactionArgs()) }

  val addStar: QTypeConfigStub<AddStarPayload, AddStarArgs> by lazy { typeConfigStub<AddStarPayload, AddStarArgs>(AddStarArgs()) }

  val createProject: QTypeConfigStub<CreateProjectPayload, CreateProjectArgs> by lazy { typeConfigStub<CreateProjectPayload, CreateProjectArgs>(CreateProjectArgs()) }

  val declineTopicSuggestion: QTypeConfigStub<DeclineTopicSuggestionPayload, DeclineTopicSuggestionArgs> by lazy { typeConfigStub<DeclineTopicSuggestionPayload, DeclineTopicSuggestionArgs>(DeclineTopicSuggestionArgs()) }

  val deleteProject: QTypeConfigStub<DeleteProjectPayload, DeleteProjectArgs> by lazy { typeConfigStub<DeleteProjectPayload, DeleteProjectArgs>(DeleteProjectArgs()) }

  val deleteProjectCard: QTypeConfigStub<DeleteProjectCardPayload, DeleteProjectCardArgs> by lazy { typeConfigStub<DeleteProjectCardPayload, DeleteProjectCardArgs>(DeleteProjectCardArgs()) }

  val deleteProjectColumn: QTypeConfigStub<DeleteProjectColumnPayload, DeleteProjectColumnArgs> by lazy { typeConfigStub<DeleteProjectColumnPayload, DeleteProjectColumnArgs>(DeleteProjectColumnArgs()) }

  val deletePullRequestReview: QTypeConfigStub<DeletePullRequestReviewPayload, DeletePullRequestReviewArgs> by lazy { typeConfigStub<DeletePullRequestReviewPayload, DeletePullRequestReviewArgs>(DeletePullRequestReviewArgs()) }

  val dismissPullRequestReview: QTypeConfigStub<DismissPullRequestReviewPayload, DismissPullRequestReviewArgs> by lazy { typeConfigStub<DismissPullRequestReviewPayload, DismissPullRequestReviewArgs>(DismissPullRequestReviewArgs()) }

  val moveProjectCard: QTypeConfigStub<MoveProjectCardPayload, MoveProjectCardArgs> by lazy { typeConfigStub<MoveProjectCardPayload, MoveProjectCardArgs>(MoveProjectCardArgs()) }

  val moveProjectColumn: QTypeConfigStub<MoveProjectColumnPayload, MoveProjectColumnArgs> by lazy { typeConfigStub<MoveProjectColumnPayload, MoveProjectColumnArgs>(MoveProjectColumnArgs()) }

  val removeOutsideCollaborator: QTypeConfigStub<RemoveOutsideCollaboratorPayload, RemoveOutsideCollaboratorArgs> by lazy { typeConfigStub<RemoveOutsideCollaboratorPayload, RemoveOutsideCollaboratorArgs>(RemoveOutsideCollaboratorArgs()) }

  val removeReaction: QTypeConfigStub<RemoveReactionPayload, RemoveReactionArgs> by lazy { typeConfigStub<RemoveReactionPayload, RemoveReactionArgs>(RemoveReactionArgs()) }

  val removeStar: QTypeConfigStub<RemoveStarPayload, RemoveStarArgs> by lazy { typeConfigStub<RemoveStarPayload, RemoveStarArgs>(RemoveStarArgs()) }

  val requestReviews: QTypeConfigStub<RequestReviewsPayload, RequestReviewsArgs> by lazy { typeConfigStub<RequestReviewsPayload, RequestReviewsArgs>(RequestReviewsArgs()) }

  val submitPullRequestReview: QTypeConfigStub<SubmitPullRequestReviewPayload, SubmitPullRequestReviewArgs> by lazy { typeConfigStub<SubmitPullRequestReviewPayload, SubmitPullRequestReviewArgs>(SubmitPullRequestReviewArgs()) }

  val updateProject: QTypeConfigStub<UpdateProjectPayload, UpdateProjectArgs> by lazy { typeConfigStub<UpdateProjectPayload, UpdateProjectArgs>(UpdateProjectArgs()) }

  val updateProjectCard: QTypeConfigStub<UpdateProjectCardPayload, UpdateProjectCardArgs> by lazy { typeConfigStub<UpdateProjectCardPayload, UpdateProjectCardArgs>(UpdateProjectCardArgs()) }

  val updateProjectColumn: QTypeConfigStub<UpdateProjectColumnPayload, UpdateProjectColumnArgs> by lazy { typeConfigStub<UpdateProjectColumnPayload, UpdateProjectColumnArgs>(UpdateProjectColumnArgs()) }

  val updatePullRequestReview: QTypeConfigStub<UpdatePullRequestReviewPayload, UpdatePullRequestReviewArgs> by lazy { typeConfigStub<UpdatePullRequestReviewPayload, UpdatePullRequestReviewArgs>(UpdatePullRequestReviewArgs()) }

  val updatePullRequestReviewComment: QTypeConfigStub<UpdatePullRequestReviewCommentPayload, UpdatePullRequestReviewCommentArgs> by lazy { typeConfigStub<UpdatePullRequestReviewCommentPayload, UpdatePullRequestReviewCommentArgs>(UpdatePullRequestReviewCommentArgs()) }

  val updateSubscription: QTypeConfigStub<UpdateSubscriptionPayload, UpdateSubscriptionArgs> by lazy { typeConfigStub<UpdateSubscriptionPayload, UpdateSubscriptionArgs>(UpdateSubscriptionArgs()) }

  val updateTopics: QTypeConfigStub<UpdateTopicsPayload, UpdateTopicsArgs> by lazy { typeConfigStub<UpdateTopicsPayload, UpdateTopicsArgs>(UpdateTopicsArgs()) }

  class AcceptTopicSuggestionArgs(args: TypeArgBuilder = TypeArgBuilder.create<AcceptTopicSuggestionPayload, AcceptTopicSuggestionArgs>()) : TypeArgBuilder by args {
    fun input(value: AcceptTopicSuggestionInput): AcceptTopicSuggestionArgs = apply { addArg("input", value) }

  }

  class AddCommentArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddCommentPayload, AddCommentArgs>()) : TypeArgBuilder by args {
    fun input(value: AddCommentInput): AddCommentArgs = apply { addArg("input", value) }

  }

  class AddProjectCardArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddProjectCardPayload, AddProjectCardArgs>()) : TypeArgBuilder by args {
    fun input(value: AddProjectCardInput): AddProjectCardArgs = apply { addArg("input", value) }

  }

  class AddProjectColumnArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddProjectColumnPayload, AddProjectColumnArgs>()) : TypeArgBuilder by args {
    fun input(value: AddProjectColumnInput): AddProjectColumnArgs = apply { addArg("input", value) }

  }

  class AddPullRequestReviewArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddPullRequestReviewPayload, AddPullRequestReviewArgs>()) : TypeArgBuilder by args {
    fun input(value: AddPullRequestReviewInput): AddPullRequestReviewArgs = apply { addArg("input", value) }

  }

  class AddPullRequestReviewCommentArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddPullRequestReviewCommentPayload, AddPullRequestReviewCommentArgs>()) : TypeArgBuilder by args {
    fun input(value: AddPullRequestReviewCommentInput): AddPullRequestReviewCommentArgs = apply { addArg("input", value) }

  }

  class AddReactionArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddReactionPayload, AddReactionArgs>()) : TypeArgBuilder by args {
    fun input(value: AddReactionInput): AddReactionArgs = apply { addArg("input", value) }

  }

  class AddStarArgs(args: TypeArgBuilder = TypeArgBuilder.create<AddStarPayload, AddStarArgs>()) : TypeArgBuilder by args {
    fun input(value: AddStarInput): AddStarArgs = apply { addArg("input", value) }

  }

  class CreateProjectArgs(args: TypeArgBuilder = TypeArgBuilder.create<CreateProjectPayload, CreateProjectArgs>()) : TypeArgBuilder by args {
    fun input(value: CreateProjectInput): CreateProjectArgs = apply { addArg("input", value) }

  }

  class DeclineTopicSuggestionArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeclineTopicSuggestionPayload, DeclineTopicSuggestionArgs>()) : TypeArgBuilder by args {
    fun input(value: DeclineTopicSuggestionInput): DeclineTopicSuggestionArgs = apply { addArg("input", value) }

  }

  class DeleteProjectArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeleteProjectPayload, DeleteProjectArgs>()) : TypeArgBuilder by args {
    fun input(value: DeleteProjectInput): DeleteProjectArgs = apply { addArg("input", value) }

  }

  class DeleteProjectCardArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeleteProjectCardPayload, DeleteProjectCardArgs>()) : TypeArgBuilder by args {
    fun input(value: DeleteProjectCardInput): DeleteProjectCardArgs = apply { addArg("input", value) }

  }

  class DeleteProjectColumnArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeleteProjectColumnPayload, DeleteProjectColumnArgs>()) : TypeArgBuilder by args {
    fun input(value: DeleteProjectColumnInput): DeleteProjectColumnArgs = apply { addArg("input", value) }

  }

  class DeletePullRequestReviewArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeletePullRequestReviewPayload, DeletePullRequestReviewArgs>()) : TypeArgBuilder by args {
    fun input(value: DeletePullRequestReviewInput): DeletePullRequestReviewArgs = apply { addArg("input", value) }

  }

  class DismissPullRequestReviewArgs(args: TypeArgBuilder = TypeArgBuilder.create<DismissPullRequestReviewPayload, DismissPullRequestReviewArgs>()) : TypeArgBuilder by args {
    fun input(value: DismissPullRequestReviewInput): DismissPullRequestReviewArgs = apply { addArg("input", value) }

  }

  class MoveProjectCardArgs(args: TypeArgBuilder = TypeArgBuilder.create<MoveProjectCardPayload, MoveProjectCardArgs>()) : TypeArgBuilder by args {
    fun input(value: MoveProjectCardInput): MoveProjectCardArgs = apply { addArg("input", value) }

  }

  class MoveProjectColumnArgs(args: TypeArgBuilder = TypeArgBuilder.create<MoveProjectColumnPayload, MoveProjectColumnArgs>()) : TypeArgBuilder by args {
    fun input(value: MoveProjectColumnInput): MoveProjectColumnArgs = apply { addArg("input", value) }

  }

  class RemoveOutsideCollaboratorArgs(args: TypeArgBuilder = TypeArgBuilder.create<RemoveOutsideCollaboratorPayload, RemoveOutsideCollaboratorArgs>()) : TypeArgBuilder by args {
    fun input(value: RemoveOutsideCollaboratorInput): RemoveOutsideCollaboratorArgs = apply { addArg("input", value) }

  }

  class RemoveReactionArgs(args: TypeArgBuilder = TypeArgBuilder.create<RemoveReactionPayload, RemoveReactionArgs>()) : TypeArgBuilder by args {
    fun input(value: RemoveReactionInput): RemoveReactionArgs = apply { addArg("input", value) }

  }

  class RemoveStarArgs(args: TypeArgBuilder = TypeArgBuilder.create<RemoveStarPayload, RemoveStarArgs>()) : TypeArgBuilder by args {
    fun input(value: RemoveStarInput): RemoveStarArgs = apply { addArg("input", value) }

  }

  class RequestReviewsArgs(args: TypeArgBuilder = TypeArgBuilder.create<RequestReviewsPayload, RequestReviewsArgs>()) : TypeArgBuilder by args {
    fun input(value: RequestReviewsInput): RequestReviewsArgs = apply { addArg("input", value) }

  }

  class SubmitPullRequestReviewArgs(args: TypeArgBuilder = TypeArgBuilder.create<SubmitPullRequestReviewPayload, SubmitPullRequestReviewArgs>()) : TypeArgBuilder by args {
    fun input(value: SubmitPullRequestReviewInput): SubmitPullRequestReviewArgs = apply { addArg("input", value) }

  }

  class UpdateProjectArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdateProjectPayload, UpdateProjectArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdateProjectInput): UpdateProjectArgs = apply { addArg("input", value) }

  }

  class UpdateProjectCardArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdateProjectCardPayload, UpdateProjectCardArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdateProjectCardInput): UpdateProjectCardArgs = apply { addArg("input", value) }

  }

  class UpdateProjectColumnArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdateProjectColumnPayload, UpdateProjectColumnArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdateProjectColumnInput): UpdateProjectColumnArgs = apply { addArg("input", value) }

  }

  class UpdatePullRequestReviewArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdatePullRequestReviewPayload, UpdatePullRequestReviewArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdatePullRequestReviewInput): UpdatePullRequestReviewArgs = apply { addArg("input", value) }

  }

  class UpdatePullRequestReviewCommentArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdatePullRequestReviewCommentPayload, UpdatePullRequestReviewCommentArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdatePullRequestReviewCommentInput): UpdatePullRequestReviewCommentArgs = apply { addArg("input", value) }

  }

  class UpdateSubscriptionArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdateSubscriptionPayload, UpdateSubscriptionArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdateSubscriptionInput): UpdateSubscriptionArgs = apply { addArg("input", value) }

  }

  class UpdateTopicsArgs(args: TypeArgBuilder = TypeArgBuilder.create<UpdateTopicsPayload, UpdateTopicsArgs>()) : TypeArgBuilder by args {
    fun input(value: UpdateTopicsInput): UpdateTopicsArgs = apply { addArg("input", value) }

  }
}

interface Node : QSchemaType {
  val id: Stub<String>
}

enum class OrderDirection : QSchemaType {
  ASC,

  DESC
}

object Organization : QSchemaType, UniformResourceLocatable, RepositoryOwner, ProjectOwner, Actor, Node {
  override val avatarUrl: QConfigStub<URI, AvatarUrlArgs> by lazy { configStub<URI, AvatarUrlArgs>(AvatarUrlArgs()) }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isInvoiced: Stub<Boolean> by lazy { stub<Boolean>() }

  override val login: Stub<String> by lazy { stub<String>() }

  val members: QTypeConfigStub<UserConnection, MembersArgs> by lazy { typeConfigStub<UserConnection, MembersArgs>(MembersArgs()) }

  val name: Stub<String> by lazy { stub<String>() }

  val newTeamResourcePath: Stub<URI> by lazy { stub<URI>() }

  val newTeamUrl: Stub<URI> by lazy { stub<URI>() }

  val organizationBillingEmail: Stub<String> by lazy { stub<String>() }

  override val pinnedRepositories: QTypeConfigStub<RepositoryConnection, RepositoryOwner.PinnedRepositoriesArgs> by lazy { typeConfigStub<RepositoryConnection, RepositoryOwner.PinnedRepositoriesArgs>(RepositoryOwner.PinnedRepositoriesArgs()) }

  override val project: QTypeConfigStub<Project, ProjectOwner.ProjectArgs> by lazy { typeConfigStub<Project, ProjectOwner.ProjectArgs>(ProjectOwner.ProjectArgs()) }

  override val projects: QTypeConfigStub<ProjectConnection, ProjectOwner.ProjectsArgs> by lazy { typeConfigStub<ProjectConnection, ProjectOwner.ProjectsArgs>(ProjectOwner.ProjectsArgs()) }

  override val projectsResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val projectsUrl: Stub<URI> by lazy { stub<URI>() }

  override val repositories: QTypeConfigStub<RepositoryConnection, RepositoryOwner.RepositoriesArgs> by lazy { typeConfigStub<RepositoryConnection, RepositoryOwner.RepositoriesArgs>(RepositoryOwner.RepositoriesArgs()) }

  override val repository: QTypeConfigStub<Repository, RepositoryOwner.RepositoryArgs> by lazy { typeConfigStub<Repository, RepositoryOwner.RepositoryArgs>(RepositoryOwner.RepositoryArgs()) }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val samlIdentityProvider: InitStub<OrganizationIdentityProvider> by lazy { typeStub<OrganizationIdentityProvider>() }

  val team: QTypeConfigStub<Team, TeamArgs> by lazy { typeConfigStub<Team, TeamArgs>(TeamArgs()) }

  val teams: QTypeConfigStub<TeamConnection, TeamsArgs> by lazy { typeConfigStub<TeamConnection, TeamsArgs>(TeamsArgs()) }

  val teamsResourcePath: Stub<URI> by lazy { stub<URI>() }

  val teamsUrl: Stub<URI> by lazy { stub<URI>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  val viewerCanAdminister: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanCreateProjects: Stub<Boolean> by lazy { stub<Boolean>() }

  val viewerCanCreateRepositories: Stub<Boolean> by lazy { stub<Boolean>() }

  val viewerCanCreateTeams: Stub<Boolean> by lazy { stub<Boolean>() }

  val viewerIsAMember: Stub<Boolean> by lazy { stub<Boolean>() }

  class AvatarUrlArgs(args: ArgBuilder = ArgBuilder.create<URI, AvatarUrlArgs>()) : BaseAvatarUrlArgs(args) {
    fun size(value: Int): AvatarUrlArgs = apply { addArg("size", value) }

  }

  class MembersArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, MembersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): MembersArgs = apply { addArg("first", value) }


    fun after(value: String): MembersArgs = apply { addArg("after", value) }


    fun last(value: Int): MembersArgs = apply { addArg("last", value) }


    fun before(value: String): MembersArgs = apply { addArg("before", value) }

  }

  class TeamArgs(args: TypeArgBuilder = TypeArgBuilder.create<Team, TeamArgs>()) : TypeArgBuilder by args {
    fun slug(value: String): TeamArgs = apply { addArg("slug", value) }

  }

  class TeamsArgs(args: TypeArgBuilder = TypeArgBuilder.create<TeamConnection, TeamsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): TeamsArgs = apply { addArg("first", value) }


    fun after(value: String): TeamsArgs = apply { addArg("after", value) }


    fun last(value: Int): TeamsArgs = apply { addArg("last", value) }


    fun before(value: String): TeamsArgs = apply { addArg("before", value) }


    fun privacy(value: TeamPrivacy): TeamsArgs = apply { addArg("privacy", value) }


    fun role(value: TeamRole): TeamsArgs = apply { addArg("role", value) }


    fun query(value: String): TeamsArgs = apply { addArg("query", value) }


    fun userLogins(value: String): TeamsArgs = apply { addArg("userLogins", value) }


    fun orderBy(value: TeamOrder): TeamsArgs = apply { addArg("orderBy", value) }


    fun ldapMapped(value: Boolean): TeamsArgs = apply { addArg("ldapMapped", value) }

  }
}

object OrganizationConnection : QSchemaType {
  val edges: InitStub<OrganizationEdge> by lazy { typeStub<OrganizationEdge>() }

  val nodes: InitStub<Organization> by lazy { typeStub<Organization>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object OrganizationEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Organization> by lazy { typeStub<Organization>() }
}

object OrganizationIdentityProvider : QSchemaType, Node {
  val digestMethod: Stub<URI> by lazy { stub<URI>() }

  val externalIdentities: QTypeConfigStub<ExternalIdentityConnection, ExternalIdentitiesArgs> by lazy { typeConfigStub<ExternalIdentityConnection, ExternalIdentitiesArgs>(ExternalIdentitiesArgs()) }

  override val id: Stub<String> by lazy { stub<String>() }

  val idpCertificate: Stub<X509Certificate> by lazy { stub<X509Certificate>() }

  val issuer: Stub<String> by lazy { stub<String>() }

  val organization: InitStub<Organization> by lazy { typeStub<Organization>() }

  val signatureMethod: Stub<URI> by lazy { stub<URI>() }

  val ssoUrl: Stub<URI> by lazy { stub<URI>() }

  class ExternalIdentitiesArgs(args: TypeArgBuilder = TypeArgBuilder.create<ExternalIdentityConnection, ExternalIdentitiesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ExternalIdentitiesArgs = apply { addArg("first", value) }


    fun after(value: String): ExternalIdentitiesArgs = apply { addArg("after", value) }


    fun last(value: Int): ExternalIdentitiesArgs = apply { addArg("last", value) }


    fun before(value: String): ExternalIdentitiesArgs = apply { addArg("before", value) }

  }
}

object OrganizationInvitation : QSchemaType {
  val email: Stub<String> by lazy { stub<String>() }

  val id: Stub<String> by lazy { stub<String>() }

  val invitee: InitStub<User> by lazy { typeStub<User>() }

  val inviter: InitStub<User> by lazy { typeStub<User>() }

  val role: Stub<OrganizationInvitationRole> by lazy { stub<OrganizationInvitationRole>() }
}

object OrganizationInvitationConnection : QSchemaType {
  val edges: InitStub<OrganizationInvitationEdge> by lazy { typeStub<OrganizationInvitationEdge>() }

  val nodes: InitStub<OrganizationInvitation> by lazy { typeStub<OrganizationInvitation>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object OrganizationInvitationEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<OrganizationInvitation> by lazy { typeStub<OrganizationInvitation>() }
}

enum class OrganizationInvitationRole : QSchemaType {
  DIRECT_MEMBER,

  ADMIN,

  BILLING_MANAGER,

  REINSTATE
}

object PageInfo : QSchemaType {
  val endCursor: Stub<String> by lazy { stub<String>() }

  val hasNextPage: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasPreviousPage: Stub<Boolean> by lazy { stub<Boolean>() }

  val startCursor: Stub<String> by lazy { stub<String>() }
}

object Project : QSchemaType, Updatable, Node {
  val body: Stub<String> by lazy { stub<String>() }

  val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val closedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val columns: QTypeConfigStub<ProjectColumnConnection, ColumnsArgs> by lazy { typeConfigStub<ProjectColumnConnection, ColumnsArgs>(ColumnsArgs()) }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val number: Stub<Int> by lazy { stub<Int>() }

  val owner: InitStub<ProjectOwner> by lazy { typeStub<ProjectOwner>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<ProjectState> by lazy { stub<ProjectState>() }

  val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  class ColumnsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ProjectColumnConnection, ColumnsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ColumnsArgs = apply { addArg("first", value) }


    fun after(value: String): ColumnsArgs = apply { addArg("after", value) }


    fun last(value: Int): ColumnsArgs = apply { addArg("last", value) }


    fun before(value: String): ColumnsArgs = apply { addArg("before", value) }

  }
}

object ProjectCard : QSchemaType, Node {
  val column: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }

  val content: InitStub<ProjectCardItem> by lazy { typeStub<ProjectCardItem>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val note: Stub<String> by lazy { stub<String>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }

  val projectColumn: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<ProjectCardState> by lazy { stub<ProjectCardState>() }

  val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val url: Stub<URI> by lazy { stub<URI>() }
}

object ProjectCardConnection : QSchemaType {
  val edges: InitStub<ProjectCardEdge> by lazy { typeStub<ProjectCardEdge>() }

  val nodes: InitStub<ProjectCard> by lazy { typeStub<ProjectCard>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ProjectCardEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ProjectCard> by lazy { typeStub<ProjectCard>() }
}

object ProjectCardItem : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

enum class ProjectCardState : QSchemaType {
  CONTENT_ONLY,

  NOTE_ONLY,

  REDACTED
}

object ProjectColumn : QSchemaType, Node {
  val cards: QTypeConfigStub<ProjectCardConnection, CardsArgs> by lazy { typeConfigStub<ProjectCardConnection, CardsArgs>(CardsArgs()) }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }

  val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  class CardsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ProjectCardConnection, CardsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CardsArgs = apply { addArg("first", value) }


    fun after(value: String): CardsArgs = apply { addArg("after", value) }


    fun last(value: Int): CardsArgs = apply { addArg("last", value) }


    fun before(value: String): CardsArgs = apply { addArg("before", value) }

  }
}

object ProjectColumnConnection : QSchemaType {
  val edges: InitStub<ProjectColumnEdge> by lazy { typeStub<ProjectColumnEdge>() }

  val nodes: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ProjectColumnEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }
}

object ProjectConnection : QSchemaType {
  val edges: InitStub<ProjectEdge> by lazy { typeStub<ProjectEdge>() }

  val nodes: InitStub<Project> by lazy { typeStub<Project>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ProjectEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Project> by lazy { typeStub<Project>() }
}

data class ProjectOrder(private val field: ProjectOrderField,
    private val direction: OrderDirection) : QInput

enum class ProjectOrderField : QSchemaType {
  CREATED_AT,

  UPDATED_AT,

  NAME
}

interface ProjectOwner : QSchemaType {
  val id: Stub<String>

  val project: QTypeConfigStub<Project, ProjectArgs>

  val projects: QTypeConfigStub<ProjectConnection, ProjectsArgs>

  val projectsResourcePath: Stub<URI>

  val projectsUrl: Stub<URI>

  val viewerCanCreateProjects: Stub<Boolean>

  class ProjectArgs(args: TypeArgBuilder = TypeArgBuilder.create<Project, ProjectArgs>()) : TypeArgBuilder by args {
    fun number(value: Int): ProjectArgs = apply { addArg("number", value) }

  }

  class ProjectsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ProjectConnection, ProjectsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ProjectsArgs = apply { addArg("first", value) }


    fun after(value: String): ProjectsArgs = apply { addArg("after", value) }


    fun last(value: Int): ProjectsArgs = apply { addArg("last", value) }


    fun before(value: String): ProjectsArgs = apply { addArg("before", value) }


    fun orderBy(value: ProjectOrder): ProjectsArgs = apply { addArg("orderBy", value) }


    fun search(value: String): ProjectsArgs = apply { addArg("search", value) }


    fun states(value: ProjectState): ProjectsArgs = apply { addArg("states", value) }

  }
}

enum class ProjectState : QSchemaType {
  OPEN,

  CLOSED
}

object ProtectedBranch : QSchemaType, Node {
  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val hasDismissableStaleReviews: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasRequiredReviews: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasRequiredStatusChecks: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasRestrictedPushes: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasRestrictedReviewDismissals: Stub<Boolean> by lazy { stub<Boolean>() }

  val hasStrictRequiredStatusChecks: Stub<Boolean> by lazy { stub<Boolean>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isAdminEnforced: Stub<Boolean> by lazy { stub<Boolean>() }

  val name: Stub<String> by lazy { stub<String>() }

  val pushAllowances: QTypeConfigStub<PushAllowanceConnection, PushAllowancesArgs> by lazy { typeConfigStub<PushAllowanceConnection, PushAllowancesArgs>(PushAllowancesArgs()) }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val requiredStatusCheckContexts: Stub<String> by lazy { stub<String>() }

  val reviewDismissalAllowances: QTypeConfigStub<ReviewDismissalAllowanceConnection, ReviewDismissalAllowancesArgs> by lazy { typeConfigStub<ReviewDismissalAllowanceConnection, ReviewDismissalAllowancesArgs>(ReviewDismissalAllowancesArgs()) }

  class PushAllowancesArgs(args: TypeArgBuilder = TypeArgBuilder.create<PushAllowanceConnection, PushAllowancesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): PushAllowancesArgs = apply { addArg("first", value) }


    fun after(value: String): PushAllowancesArgs = apply { addArg("after", value) }


    fun last(value: Int): PushAllowancesArgs = apply { addArg("last", value) }


    fun before(value: String): PushAllowancesArgs = apply { addArg("before", value) }

  }

  class ReviewDismissalAllowancesArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReviewDismissalAllowanceConnection, ReviewDismissalAllowancesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReviewDismissalAllowancesArgs = apply { addArg("first", value) }


    fun after(value: String): ReviewDismissalAllowancesArgs = apply { addArg("after", value) }


    fun last(value: Int): ReviewDismissalAllowancesArgs = apply { addArg("last", value) }


    fun before(value: String): ReviewDismissalAllowancesArgs = apply { addArg("before", value) }

  }
}

object ProtectedBranchConnection : QSchemaType {
  val edges: InitStub<ProtectedBranchEdge> by lazy { typeStub<ProtectedBranchEdge>() }

  val nodes: InitStub<ProtectedBranch> by lazy { typeStub<ProtectedBranch>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ProtectedBranchEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ProtectedBranch> by lazy { typeStub<ProtectedBranch>() }
}

object PullRequest : QSchemaType, UniformResourceLocatable, Subscribable, RepositoryNode, Reactable, Lockable, Labelable, UpdatableComment, Updatable, Comment, Closable, Assignable, Node {
  override val assignees: QTypeConfigStub<UserConnection, Assignable.AssigneesArgs> by lazy { typeConfigStub<UserConnection, Assignable.AssigneesArgs>(Assignable.AssigneesArgs()) }

  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  val baseRef: InitStub<Ref> by lazy { typeStub<Ref>() }

  val baseRefName: Stub<String> by lazy { stub<String>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val bodyText: Stub<String> by lazy { stub<String>() }

  override val closed: Stub<Boolean> by lazy { stub<Boolean>() }

  val comments: QTypeConfigStub<IssueCommentConnection, CommentsArgs> by lazy { typeConfigStub<IssueCommentConnection, CommentsArgs>(CommentsArgs()) }

  val commits: QTypeConfigStub<PullRequestCommitConnection, CommitsArgs> by lazy { typeConfigStub<PullRequestCommitConnection, CommitsArgs>(CommitsArgs()) }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val headRef: InitStub<Ref> by lazy { typeStub<Ref>() }

  val headRefName: Stub<String> by lazy { stub<String>() }

  val headRepository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val headRepositoryOwner: InitStub<RepositoryOwner> by lazy { typeStub<RepositoryOwner>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isCrossRepository: Stub<Boolean> by lazy { stub<Boolean>() }

  override val labels: QTypeConfigStub<LabelConnection, Labelable.LabelsArgs> by lazy { typeConfigStub<LabelConnection, Labelable.LabelsArgs>(Labelable.LabelsArgs()) }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val locked: Stub<Boolean> by lazy { stub<Boolean>() }

  val mergeCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val mergeable: Stub<MergeableState> by lazy { stub<MergeableState>() }

  val merged: Stub<Boolean> by lazy { stub<Boolean>() }

  val mergedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val number: Stub<Int> by lazy { stub<Int>() }

  val participants: QTypeConfigStub<UserConnection, ParticipantsArgs> by lazy { typeConfigStub<UserConnection, ParticipantsArgs>(ParticipantsArgs()) }

  val potentialMergeCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val reactionGroups: InitStub<ReactionGroup> by lazy { typeStub<ReactionGroup>() }

  override val reactions: QTypeConfigStub<ReactionConnection, Reactable.ReactionsArgs> by lazy { typeConfigStub<ReactionConnection, Reactable.ReactionsArgs>(Reactable.ReactionsArgs()) }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val revertResourcePath: Stub<URI> by lazy { stub<URI>() }

  val revertUrl: Stub<URI> by lazy { stub<URI>() }

  val reviewRequests: QTypeConfigStub<ReviewRequestConnection, ReviewRequestsArgs> by lazy { typeConfigStub<ReviewRequestConnection, ReviewRequestsArgs>(ReviewRequestsArgs()) }

  val reviews: QTypeConfigStub<PullRequestReviewConnection, ReviewsArgs> by lazy { typeConfigStub<PullRequestReviewConnection, ReviewsArgs>(ReviewsArgs()) }

  val state: Stub<PullRequestState> by lazy { stub<PullRequestState>() }

  val suggestedReviewers: InitStub<SuggestedReviewer> by lazy { typeStub<SuggestedReviewer>() }

  val timeline: QTypeConfigStub<PullRequestTimelineConnection, TimelineArgs> by lazy { typeConfigStub<PullRequestTimelineConnection, TimelineArgs>(TimelineArgs()) }

  val title: Stub<String> by lazy { stub<String>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanReact: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanSubscribe: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerSubscription: Stub<SubscriptionState> by lazy { stub<SubscriptionState>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }

  class CommitsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestCommitConnection, CommitsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommitsArgs = apply { addArg("first", value) }


    fun after(value: String): CommitsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommitsArgs = apply { addArg("last", value) }


    fun before(value: String): CommitsArgs = apply { addArg("before", value) }

  }

  class ParticipantsArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, ParticipantsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ParticipantsArgs = apply { addArg("first", value) }


    fun after(value: String): ParticipantsArgs = apply { addArg("after", value) }


    fun last(value: Int): ParticipantsArgs = apply { addArg("last", value) }


    fun before(value: String): ParticipantsArgs = apply { addArg("before", value) }

  }

  class ReviewRequestsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReviewRequestConnection, ReviewRequestsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReviewRequestsArgs = apply { addArg("first", value) }


    fun after(value: String): ReviewRequestsArgs = apply { addArg("after", value) }


    fun last(value: Int): ReviewRequestsArgs = apply { addArg("last", value) }


    fun before(value: String): ReviewRequestsArgs = apply { addArg("before", value) }

  }

  class ReviewsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestReviewConnection, ReviewsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReviewsArgs = apply { addArg("first", value) }


    fun after(value: String): ReviewsArgs = apply { addArg("after", value) }


    fun last(value: Int): ReviewsArgs = apply { addArg("last", value) }


    fun before(value: String): ReviewsArgs = apply { addArg("before", value) }


    fun states(value: PullRequestReviewState): ReviewsArgs = apply { addArg("states", value) }

  }

  class TimelineArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestTimelineConnection, TimelineArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): TimelineArgs = apply { addArg("first", value) }


    fun after(value: String): TimelineArgs = apply { addArg("after", value) }


    fun last(value: Int): TimelineArgs = apply { addArg("last", value) }


    fun before(value: String): TimelineArgs = apply { addArg("before", value) }


    fun since(value: DateTime): TimelineArgs = apply { addArg("since", value) }

  }
}

object PullRequestCommit : QSchemaType, UniformResourceLocatable, Node {
  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

object PullRequestCommitConnection : QSchemaType {
  val edges: InitStub<PullRequestCommitEdge> by lazy { typeStub<PullRequestCommitEdge>() }

  val nodes: InitStub<PullRequestCommit> by lazy { typeStub<PullRequestCommit>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PullRequestCommitEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PullRequestCommit> by lazy { typeStub<PullRequestCommit>() }
}

object PullRequestConnection : QSchemaType {
  val edges: InitStub<PullRequestEdge> by lazy { typeStub<PullRequestEdge>() }

  val nodes: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PullRequestEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

enum class PullRequestPubSubTopic : QSchemaType {
  UPDATED,

  MARKASREAD,

  HEAD_REF
}

object PullRequestReview : QSchemaType, RepositoryNode, UpdatableComment, Updatable, Deletable, Comment, Node {
  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val bodyText: Stub<String> by lazy { stub<String>() }

  val comments: QTypeConfigStub<PullRequestReviewCommentConnection, CommentsArgs> by lazy { typeConfigStub<PullRequestReviewCommentConnection, CommentsArgs>(CommentsArgs()) }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val state: Stub<PullRequestReviewState> by lazy { stub<PullRequestReviewState>() }

  val submittedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanDelete: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestReviewCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }
}

object PullRequestReviewComment : QSchemaType, RepositoryNode, Reactable, UpdatableComment, Updatable, Deletable, Comment, Node {
  override val author: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val authorAssociation: Stub<CommentAuthorAssociation> by lazy { stub<CommentAuthorAssociation>() }

  override val body: Stub<String> by lazy { stub<String>() }

  override val bodyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val bodyText: Stub<String> by lazy { stub<String>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val createdViaEmail: Stub<Boolean> by lazy { stub<Boolean>() }

  override val databaseId: Stub<Int> by lazy { stub<Int>() }

  val diffHunk: Stub<String> by lazy { stub<String>() }

  val draftedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val editor: InitStub<Actor> by lazy { typeStub<Actor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val lastEditedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val originalCommit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val originalPosition: Stub<Int> by lazy { stub<Int>() }

  val path: Stub<String> by lazy { stub<String>() }

  val position: Stub<Int> by lazy { stub<Int>() }

  override val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }

  override val reactionGroups: InitStub<ReactionGroup> by lazy { typeStub<ReactionGroup>() }

  override val reactions: QTypeConfigStub<ReactionConnection, Reactable.ReactionsArgs> by lazy { typeConfigStub<ReactionConnection, Reactable.ReactionsArgs>(Reactable.ReactionsArgs()) }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val url: Stub<URI> by lazy { stub<URI>() }

  override val viewerCanDelete: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanReact: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanUpdate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason> by lazy { stub<CommentCannotUpdateReason>() }

  override val viewerDidAuthor: Stub<Boolean> by lazy { stub<Boolean>() }
}

object PullRequestReviewCommentConnection : QSchemaType {
  val edges: InitStub<PullRequestReviewCommentEdge> by lazy { typeStub<PullRequestReviewCommentEdge>() }

  val nodes: InitStub<PullRequestReviewComment> by lazy { typeStub<PullRequestReviewComment>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PullRequestReviewCommentEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PullRequestReviewComment> by lazy { typeStub<PullRequestReviewComment>() }
}

object PullRequestReviewConnection : QSchemaType {
  val edges: InitStub<PullRequestReviewEdge> by lazy { typeStub<PullRequestReviewEdge>() }

  val nodes: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PullRequestReviewEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }
}

enum class PullRequestReviewEvent : QSchemaType {
  COMMENT,

  APPROVE,

  REQUEST_CHANGES,

  DISMISS
}

enum class PullRequestReviewState : QSchemaType {
  PENDING,

  COMMENTED,

  APPROVED,

  CHANGES_REQUESTED,

  DISMISSED
}

object PullRequestReviewThread : QSchemaType, Node {
  val comments: QTypeConfigStub<PullRequestReviewCommentConnection, CommentsArgs> by lazy { typeConfigStub<PullRequestReviewCommentConnection, CommentsArgs>(CommentsArgs()) }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  class CommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestReviewCommentConnection, CommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommentsArgs = apply { addArg("before", value) }

  }
}

enum class PullRequestState : QSchemaType {
  OPEN,

  CLOSED,

  MERGED
}

object PullRequestTimelineConnection : QSchemaType {
  val edges: InitStub<PullRequestTimelineItemEdge> by lazy { typeStub<PullRequestTimelineItemEdge>() }

  val nodes: InitStub<PullRequestTimelineItem> by lazy { typeStub<PullRequestTimelineItem>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PullRequestTimelineItem : QSchemaType {
  val Commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val CommitCommentThread: InitStub<CommitCommentThread> by lazy { typeStub<CommitCommentThread>() }

  val PullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }

  val PullRequestReviewThread: InitStub<PullRequestReviewThread> by lazy { typeStub<PullRequestReviewThread>() }

  val PullRequestReviewComment: InitStub<PullRequestReviewComment> by lazy { typeStub<PullRequestReviewComment>() }

  val IssueComment: InitStub<IssueComment> by lazy { typeStub<IssueComment>() }

  val ClosedEvent: InitStub<ClosedEvent> by lazy { typeStub<ClosedEvent>() }

  val ReopenedEvent: InitStub<ReopenedEvent> by lazy { typeStub<ReopenedEvent>() }

  val SubscribedEvent: InitStub<SubscribedEvent> by lazy { typeStub<SubscribedEvent>() }

  val UnsubscribedEvent: InitStub<UnsubscribedEvent> by lazy { typeStub<UnsubscribedEvent>() }

  val MergedEvent: InitStub<MergedEvent> by lazy { typeStub<MergedEvent>() }

  val ReferencedEvent: InitStub<ReferencedEvent> by lazy { typeStub<ReferencedEvent>() }

  val AssignedEvent: InitStub<AssignedEvent> by lazy { typeStub<AssignedEvent>() }

  val UnassignedEvent: InitStub<UnassignedEvent> by lazy { typeStub<UnassignedEvent>() }

  val LabeledEvent: InitStub<LabeledEvent> by lazy { typeStub<LabeledEvent>() }

  val UnlabeledEvent: InitStub<UnlabeledEvent> by lazy { typeStub<UnlabeledEvent>() }

  val MilestonedEvent: InitStub<MilestonedEvent> by lazy { typeStub<MilestonedEvent>() }

  val DemilestonedEvent: InitStub<DemilestonedEvent> by lazy { typeStub<DemilestonedEvent>() }

  val RenamedTitleEvent: InitStub<RenamedTitleEvent> by lazy { typeStub<RenamedTitleEvent>() }

  val LockedEvent: InitStub<LockedEvent> by lazy { typeStub<LockedEvent>() }

  val UnlockedEvent: InitStub<UnlockedEvent> by lazy { typeStub<UnlockedEvent>() }

  val DeployedEvent: InitStub<DeployedEvent> by lazy { typeStub<DeployedEvent>() }

  val HeadRefDeletedEvent: InitStub<HeadRefDeletedEvent> by lazy { typeStub<HeadRefDeletedEvent>() }

  val HeadRefRestoredEvent: InitStub<HeadRefRestoredEvent> by lazy { typeStub<HeadRefRestoredEvent>() }

  val HeadRefForcePushedEvent: InitStub<HeadRefForcePushedEvent> by lazy { typeStub<HeadRefForcePushedEvent>() }

  val BaseRefForcePushedEvent: InitStub<BaseRefForcePushedEvent> by lazy { typeStub<BaseRefForcePushedEvent>() }

  val ReviewRequestedEvent: InitStub<ReviewRequestedEvent> by lazy { typeStub<ReviewRequestedEvent>() }

  val ReviewRequestRemovedEvent: InitStub<ReviewRequestRemovedEvent> by lazy { typeStub<ReviewRequestRemovedEvent>() }

  val ReviewDismissedEvent: InitStub<ReviewDismissedEvent> by lazy { typeStub<ReviewDismissedEvent>() }
}

object PullRequestTimelineItemEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PullRequestTimelineItem> by lazy { typeStub<PullRequestTimelineItem>() }
}

object PushAllowance : QSchemaType, Node {
  val actor: InitStub<PushAllowanceActor> by lazy { typeStub<PushAllowanceActor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val protectedBranch: InitStub<ProtectedBranch> by lazy { typeStub<ProtectedBranch>() }
}

object PushAllowanceActor : QSchemaType {
  val User: InitStub<User> by lazy { typeStub<User>() }

  val Team: InitStub<Team> by lazy { typeStub<Team>() }
}

object PushAllowanceConnection : QSchemaType {
  val edges: InitStub<PushAllowanceEdge> by lazy { typeStub<PushAllowanceEdge>() }

  val nodes: InitStub<PushAllowance> by lazy { typeStub<PushAllowance>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object PushAllowanceEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<PushAllowance> by lazy { typeStub<PushAllowance>() }
}

object Query : QSchemaType {
  val codeOfConduct: QTypeConfigStub<CodeOfConduct, CodeOfConductArgs> by lazy { typeConfigStub<CodeOfConduct, CodeOfConductArgs>(CodeOfConductArgs()) }

  val codesOfConduct: InitStub<CodeOfConduct> by lazy { typeStub<CodeOfConduct>() }

  val node: QTypeConfigStub<Node, NodeArgs> by lazy { typeConfigStub<Node, NodeArgs>(NodeArgs()) }

  val nodes: QTypeConfigStub<Node, NodesArgs> by lazy { typeConfigStub<Node, NodesArgs>(NodesArgs()) }

  val organization: QTypeConfigStub<Organization, OrganizationArgs> by lazy { typeConfigStub<Organization, OrganizationArgs>(OrganizationArgs()) }

  val rateLimit: InitStub<RateLimit> by lazy { typeStub<RateLimit>() }

  val relay: InitStub<Query> by lazy { typeStub<Query>() }

  val repository: QTypeConfigStub<Repository, RepositoryArgs> by lazy { typeConfigStub<Repository, RepositoryArgs>(RepositoryArgs()) }

  val repositoryOwner: QTypeConfigStub<RepositoryOwner, RepositoryOwnerArgs> by lazy { typeConfigStub<RepositoryOwner, RepositoryOwnerArgs>(RepositoryOwnerArgs()) }

  val resource: QTypeConfigStub<UniformResourceLocatable, ResourceArgs> by lazy { typeConfigStub<UniformResourceLocatable, ResourceArgs>(ResourceArgs()) }

  val search: QTypeConfigStub<SearchResultItemConnection, SearchArgs> by lazy { typeConfigStub<SearchResultItemConnection, SearchArgs>(SearchArgs()) }

  val topic: QTypeConfigStub<Topic, TopicArgs> by lazy { typeConfigStub<Topic, TopicArgs>(TopicArgs()) }

  val user: QTypeConfigStub<User, UserArgs> by lazy { typeConfigStub<User, UserArgs>(UserArgs()) }

  val viewer: InitStub<User> by lazy { typeStub<User>() }

  class CodeOfConductArgs(args: TypeArgBuilder = TypeArgBuilder.create<CodeOfConduct, CodeOfConductArgs>()) : TypeArgBuilder by args {
    fun key(value: String): CodeOfConductArgs = apply { addArg("key", value) }

  }

  class NodeArgs(args: TypeArgBuilder = TypeArgBuilder.create<Node, NodeArgs>()) : TypeArgBuilder by args {
    fun id(value: String): NodeArgs = apply { addArg("id", value) }

  }

  class NodesArgs(args: TypeArgBuilder = TypeArgBuilder.create<Node, NodesArgs>()) : TypeArgBuilder by args {
    fun ids(value: String): NodesArgs = apply { addArg("ids", value) }

  }

  class OrganizationArgs(args: TypeArgBuilder = TypeArgBuilder.create<Organization, OrganizationArgs>()) : TypeArgBuilder by args {
    fun login(value: String): OrganizationArgs = apply { addArg("login", value) }

  }

  class RepositoryArgs(args: TypeArgBuilder = TypeArgBuilder.create<Repository, RepositoryArgs>()) : TypeArgBuilder by args {
    fun owner(value: String): RepositoryArgs = apply { addArg("owner", value) }


    fun name(value: String): RepositoryArgs = apply { addArg("name", value) }

  }

  class RepositoryOwnerArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryOwner, RepositoryOwnerArgs>()) : TypeArgBuilder by args {
    fun login(value: String): RepositoryOwnerArgs = apply { addArg("login", value) }

  }

  class ResourceArgs(args: TypeArgBuilder = TypeArgBuilder.create<UniformResourceLocatable, ResourceArgs>()) : TypeArgBuilder by args {
    fun url(value: URI): ResourceArgs = apply { addArg("url", value) }

  }

  class SearchArgs(args: TypeArgBuilder = TypeArgBuilder.create<SearchResultItemConnection, SearchArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): SearchArgs = apply { addArg("first", value) }


    fun after(value: String): SearchArgs = apply { addArg("after", value) }


    fun last(value: Int): SearchArgs = apply { addArg("last", value) }


    fun before(value: String): SearchArgs = apply { addArg("before", value) }


    fun query(value: String): SearchArgs = apply { addArg("query", value) }


    fun type(value: SearchType): SearchArgs = apply { addArg("type", value) }

  }

  class TopicArgs(args: TypeArgBuilder = TypeArgBuilder.create<Topic, TopicArgs>()) : TypeArgBuilder by args {
    fun name(value: String): TopicArgs = apply { addArg("name", value) }

  }

  class UserArgs(args: TypeArgBuilder = TypeArgBuilder.create<User, UserArgs>()) : TypeArgBuilder by args {
    fun login(value: String): UserArgs = apply { addArg("login", value) }

  }
}

object RateLimit : QSchemaType {
  val cost: Stub<Int> by lazy { stub<Int>() }

  val limit: Stub<Int> by lazy { stub<Int>() }

  val remaining: Stub<Int> by lazy { stub<Int>() }

  val resetAt: Stub<DateTime> by lazy { stub<DateTime>() }
}

interface Reactable : QSchemaType {
  val databaseId: Stub<Int>

  val id: Stub<String>

  val reactionGroups: InitStub<ReactionGroup>

  val reactions: QTypeConfigStub<ReactionConnection, ReactionsArgs>

  val viewerCanReact: Stub<Boolean>

  class ReactionsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReactionConnection, ReactionsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReactionsArgs = apply { addArg("first", value) }


    fun after(value: String): ReactionsArgs = apply { addArg("after", value) }


    fun last(value: Int): ReactionsArgs = apply { addArg("last", value) }


    fun before(value: String): ReactionsArgs = apply { addArg("before", value) }


    fun content(value: ReactionContent): ReactionsArgs = apply { addArg("content", value) }


    fun orderBy(value: ReactionOrder): ReactionsArgs = apply { addArg("orderBy", value) }

  }
}

object ReactingUserConnection : QSchemaType {
  val edges: InitStub<ReactingUserEdge> by lazy { typeStub<ReactingUserEdge>() }

  val nodes: InitStub<User> by lazy { typeStub<User>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ReactingUserEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<User> by lazy { typeStub<User>() }

  val reactedAt: Stub<DateTime> by lazy { stub<DateTime>() }
}

object Reaction : QSchemaType, Node {
  val content: Stub<ReactionContent> by lazy { stub<ReactionContent>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val user: InitStub<User> by lazy { typeStub<User>() }
}

object ReactionConnection : QSchemaType {
  val edges: InitStub<ReactionEdge> by lazy { typeStub<ReactionEdge>() }

  val nodes: InitStub<Reaction> by lazy { typeStub<Reaction>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }

  val viewerHasReacted: Stub<Boolean> by lazy { stub<Boolean>() }
}

enum class ReactionContent : QSchemaType {
  THUMBS_UP,

  THUMBS_DOWN,

  LAUGH,

  HOORAY,

  CONFUSED,

  HEART
}

object ReactionEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Reaction> by lazy { typeStub<Reaction>() }
}

object ReactionGroup : QSchemaType {
  val content: Stub<ReactionContent> by lazy { stub<ReactionContent>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val subject: InitStub<Reactable> by lazy { typeStub<Reactable>() }

  val users: QTypeConfigStub<ReactingUserConnection, UsersArgs> by lazy { typeConfigStub<ReactingUserConnection, UsersArgs>(UsersArgs()) }

  val viewerHasReacted: Stub<Boolean> by lazy { stub<Boolean>() }

  class UsersArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReactingUserConnection, UsersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): UsersArgs = apply { addArg("first", value) }


    fun after(value: String): UsersArgs = apply { addArg("after", value) }


    fun last(value: Int): UsersArgs = apply { addArg("last", value) }


    fun before(value: String): UsersArgs = apply { addArg("before", value) }

  }
}

data class ReactionOrder(private val field: ReactionOrderField,
    private val direction: OrderDirection) : QInput

enum class ReactionOrderField : QSchemaType {
  CREATED_AT
}

object Ref : QSchemaType, Node {
  val associatedPullRequests: QTypeConfigStub<PullRequestConnection, AssociatedPullRequestsArgs> by lazy { typeConfigStub<PullRequestConnection, AssociatedPullRequestsArgs>(AssociatedPullRequestsArgs()) }

  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val prefix: Stub<String> by lazy { stub<String>() }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val target: InitStub<GitObject> by lazy { typeStub<GitObject>() }

  class AssociatedPullRequestsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestConnection, AssociatedPullRequestsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): AssociatedPullRequestsArgs = apply { addArg("first", value) }


    fun after(value: String): AssociatedPullRequestsArgs = apply { addArg("after", value) }


    fun last(value: Int): AssociatedPullRequestsArgs = apply { addArg("last", value) }


    fun before(value: String): AssociatedPullRequestsArgs = apply { addArg("before", value) }


    fun states(value: PullRequestState): AssociatedPullRequestsArgs = apply { addArg("states", value) }

  }
}

object RefConnection : QSchemaType {
  val edges: InitStub<RefEdge> by lazy { typeStub<RefEdge>() }

  val nodes: InitStub<Ref> by lazy { typeStub<Ref>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object RefEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Ref> by lazy { typeStub<Ref>() }
}

object ReferencedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val commitRepository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val isCrossReference: Stub<Boolean> by lazy { stub<Boolean>() }

  val isCrossRepository: Stub<Boolean> by lazy { stub<Boolean>() }

  val isDirectReference: Stub<Boolean> by lazy { stub<Boolean>() }

  val subject: InitStub<ReferencedSubject> by lazy { typeStub<ReferencedSubject>() }
}

object ReferencedSubject : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

object Release : QSchemaType, UniformResourceLocatable, Node {
  val description: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val publishedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val releaseAsset: QTypeConfigStub<ReleaseAssetConnection, ReleaseAssetArgs> by lazy { typeConfigStub<ReleaseAssetConnection, ReleaseAssetArgs>(ReleaseAssetArgs()) }

  val releaseAssets: QTypeConfigStub<ReleaseAssetConnection, ReleaseAssetsArgs> by lazy { typeConfigStub<ReleaseAssetConnection, ReleaseAssetsArgs>(ReleaseAssetsArgs()) }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val tag: InitStub<Ref> by lazy { typeStub<Ref>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  class ReleaseAssetArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReleaseAssetConnection, ReleaseAssetArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReleaseAssetArgs = apply { addArg("first", value) }


    fun after(value: String): ReleaseAssetArgs = apply { addArg("after", value) }


    fun last(value: Int): ReleaseAssetArgs = apply { addArg("last", value) }


    fun before(value: String): ReleaseAssetArgs = apply { addArg("before", value) }


    fun name(value: String): ReleaseAssetArgs = apply { addArg("name", value) }

  }

  class ReleaseAssetsArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReleaseAssetConnection, ReleaseAssetsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReleaseAssetsArgs = apply { addArg("first", value) }


    fun after(value: String): ReleaseAssetsArgs = apply { addArg("after", value) }


    fun last(value: Int): ReleaseAssetsArgs = apply { addArg("last", value) }


    fun before(value: String): ReleaseAssetsArgs = apply { addArg("before", value) }

  }
}

object ReleaseAsset : QSchemaType, Node {
  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val release: InitStub<Release> by lazy { typeStub<Release>() }

  val url: Stub<URI> by lazy { stub<URI>() }
}

object ReleaseAssetConnection : QSchemaType {
  val edges: InitStub<ReleaseAssetEdge> by lazy { typeStub<ReleaseAssetEdge>() }

  val nodes: InitStub<ReleaseAsset> by lazy { typeStub<ReleaseAsset>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ReleaseAssetEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ReleaseAsset> by lazy { typeStub<ReleaseAsset>() }
}

object ReleaseConnection : QSchemaType {
  val edges: InitStub<ReleaseEdge> by lazy { typeStub<ReleaseEdge>() }

  val nodes: InitStub<Release> by lazy { typeStub<Release>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ReleaseEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Release> by lazy { typeStub<Release>() }
}

data class RemoveOutsideCollaboratorInput(private val userId: String,
    private val organizationId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object RemoveOutsideCollaboratorPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val removedUser: InitStub<User> by lazy { typeStub<User>() }
}

data class RemoveReactionInput(private val subjectId: String,
    private val content: ReactionContent) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object RemoveReactionPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val reaction: InitStub<Reaction> by lazy { typeStub<Reaction>() }

  val subject: InitStub<Reactable> by lazy { typeStub<Reactable>() }
}

data class RemoveStarInput(private val starrableId: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object RemoveStarPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val starrable: InitStub<Starrable> by lazy { typeStub<Starrable>() }
}

object RemovedFromProjectEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object RenamedTitleEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val currentTitle: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val previousTitle: Stub<String> by lazy { stub<String>() }

  val subject: InitStub<RenamedTitleSubject> by lazy { typeStub<RenamedTitleSubject>() }
}

object RenamedTitleSubject : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }
}

object ReopenedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val closable: InitStub<Closable> by lazy { typeStub<Closable>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }
}

object Repository : QSchemaType, RepositoryInfo, UniformResourceLocatable, Starrable, Subscribable, ProjectOwner, Node {
  val codeOfConduct: InitStub<CodeOfConduct> by lazy { typeStub<CodeOfConduct>() }

  val commitComments: QTypeConfigStub<CommitCommentConnection, CommitCommentsArgs> by lazy { typeConfigStub<CommitCommentConnection, CommitCommentsArgs>(CommitCommentsArgs()) }

  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  val defaultBranchRef: InitStub<Ref> by lazy { typeStub<Ref>() }

  val deployments: QTypeConfigStub<DeploymentConnection, DeploymentsArgs> by lazy { typeConfigStub<DeploymentConnection, DeploymentsArgs>(DeploymentsArgs()) }

  override val description: Stub<String> by lazy { stub<String>() }

  override val descriptionHTML: Stub<HTML> by lazy { stub<HTML>() }

  val diskUsage: Stub<Int> by lazy { stub<Int>() }

  val forks: QTypeConfigStub<RepositoryConnection, ForksArgs> by lazy { typeConfigStub<RepositoryConnection, ForksArgs>(ForksArgs()) }

  override val hasIssuesEnabled: Stub<Boolean> by lazy { stub<Boolean>() }

  override val hasWikiEnabled: Stub<Boolean> by lazy { stub<Boolean>() }

  override val homepageUrl: Stub<URI> by lazy { stub<URI>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val isFork: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isLocked: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isMirror: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isPrivate: Stub<Boolean> by lazy { stub<Boolean>() }

  val issue: QTypeConfigStub<Issue, IssueArgs> by lazy { typeConfigStub<Issue, IssueArgs>(IssueArgs()) }

  val issueOrPullRequest: QTypeConfigStub<IssueOrPullRequest, IssueOrPullRequestArgs> by lazy { typeConfigStub<IssueOrPullRequest, IssueOrPullRequestArgs>(IssueOrPullRequestArgs()) }

  val issues: QTypeConfigStub<IssueConnection, IssuesArgs> by lazy { typeConfigStub<IssueConnection, IssuesArgs>(IssuesArgs()) }

  val label: QTypeConfigStub<Label, LabelArgs> by lazy { typeConfigStub<Label, LabelArgs>(LabelArgs()) }

  val labels: QTypeConfigStub<LabelConnection, LabelsArgs> by lazy { typeConfigStub<LabelConnection, LabelsArgs>(LabelsArgs()) }

  val languages: QTypeConfigStub<LanguageConnection, LanguagesArgs> by lazy { typeConfigStub<LanguageConnection, LanguagesArgs>(LanguagesArgs()) }

  override val license: Stub<String> by lazy { stub<String>() }

  override val lockReason: Stub<RepositoryLockReason> by lazy { stub<RepositoryLockReason>() }

  val mentionableUsers: QTypeConfigStub<UserConnection, MentionableUsersArgs> by lazy { typeConfigStub<UserConnection, MentionableUsersArgs>(MentionableUsersArgs()) }

  val milestone: QTypeConfigStub<Milestone, MilestoneArgs> by lazy { typeConfigStub<Milestone, MilestoneArgs>(MilestoneArgs()) }

  val milestones: QTypeConfigStub<MilestoneConnection, MilestonesArgs> by lazy { typeConfigStub<MilestoneConnection, MilestonesArgs>(MilestonesArgs()) }

  override val mirrorUrl: Stub<URI> by lazy { stub<URI>() }

  override val name: Stub<String> by lazy { stub<String>() }

  override val nameWithOwner: Stub<String> by lazy { stub<String>() }

  val objectVal: QTypeConfigStub<GitObject, ObjectValArgs> by lazy { typeConfigStub<GitObject, ObjectValArgs>(ObjectValArgs()) }

  override val owner: InitStub<RepositoryOwner> by lazy { typeStub<RepositoryOwner>() }

  val parent: InitStub<Repository> by lazy { typeStub<Repository>() }

  val primaryLanguage: InitStub<Language> by lazy { typeStub<Language>() }

  override val project: QTypeConfigStub<Project, ProjectOwner.ProjectArgs> by lazy { typeConfigStub<Project, ProjectOwner.ProjectArgs>(ProjectOwner.ProjectArgs()) }

  override val projects: QTypeConfigStub<ProjectConnection, ProjectOwner.ProjectsArgs> by lazy { typeConfigStub<ProjectConnection, ProjectOwner.ProjectsArgs>(ProjectOwner.ProjectsArgs()) }

  override val projectsResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val projectsUrl: Stub<URI> by lazy { stub<URI>() }

  val protectedBranches: QTypeConfigStub<ProtectedBranchConnection, ProtectedBranchesArgs> by lazy { typeConfigStub<ProtectedBranchConnection, ProtectedBranchesArgs>(ProtectedBranchesArgs()) }

  val pullRequest: QTypeConfigStub<PullRequest, PullRequestArgs> by lazy { typeConfigStub<PullRequest, PullRequestArgs>(PullRequestArgs()) }

  val pullRequests: QTypeConfigStub<PullRequestConnection, PullRequestsArgs> by lazy { typeConfigStub<PullRequestConnection, PullRequestsArgs>(PullRequestsArgs()) }

  override val pushedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val ref: QTypeConfigStub<Ref, RefArgs> by lazy { typeConfigStub<Ref, RefArgs>(RefArgs()) }

  val refs: QTypeConfigStub<RefConnection, RefsArgs> by lazy { typeConfigStub<RefConnection, RefsArgs>(RefsArgs()) }

  val releases: QTypeConfigStub<ReleaseConnection, ReleasesArgs> by lazy { typeConfigStub<ReleaseConnection, ReleasesArgs>(ReleasesArgs()) }

  val repositoryTopics: QTypeConfigStub<RepositoryTopicConnection, RepositoryTopicsArgs> by lazy { typeConfigStub<RepositoryTopicConnection, RepositoryTopicsArgs>(RepositoryTopicsArgs()) }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val stargazers: QTypeConfigStub<StargazerConnection, Starrable.StargazersArgs> by lazy { typeConfigStub<StargazerConnection, Starrable.StargazersArgs>(Starrable.StargazersArgs()) }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  val viewerCanAdminister: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanCreateProjects: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerCanSubscribe: Stub<Boolean> by lazy { stub<Boolean>() }

  val viewerCanUpdateTopics: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerHasStarred: Stub<Boolean> by lazy { stub<Boolean>() }

  override val viewerSubscription: Stub<SubscriptionState> by lazy { stub<SubscriptionState>() }

  val watchers: QTypeConfigStub<UserConnection, WatchersArgs> by lazy { typeConfigStub<UserConnection, WatchersArgs>(WatchersArgs()) }

  class CommitCommentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<CommitCommentConnection, CommitCommentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): CommitCommentsArgs = apply { addArg("first", value) }


    fun after(value: String): CommitCommentsArgs = apply { addArg("after", value) }


    fun last(value: Int): CommitCommentsArgs = apply { addArg("last", value) }


    fun before(value: String): CommitCommentsArgs = apply { addArg("before", value) }

  }

  class DeploymentsArgs(args: TypeArgBuilder = TypeArgBuilder.create<DeploymentConnection, DeploymentsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): DeploymentsArgs = apply { addArg("first", value) }


    fun after(value: String): DeploymentsArgs = apply { addArg("after", value) }


    fun last(value: Int): DeploymentsArgs = apply { addArg("last", value) }


    fun before(value: String): DeploymentsArgs = apply { addArg("before", value) }

  }

  class ForksArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryConnection, ForksArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ForksArgs = apply { addArg("first", value) }


    fun after(value: String): ForksArgs = apply { addArg("after", value) }


    fun last(value: Int): ForksArgs = apply { addArg("last", value) }


    fun before(value: String): ForksArgs = apply { addArg("before", value) }


    fun privacy(value: RepositoryPrivacy): ForksArgs = apply { addArg("privacy", value) }


    fun orderBy(value: RepositoryOrder): ForksArgs = apply { addArg("orderBy", value) }


    fun affiliations(value: RepositoryAffiliation): ForksArgs = apply { addArg("affiliations", value) }


    fun isLocked(value: Boolean): ForksArgs = apply { addArg("isLocked", value) }

  }

  class IssueArgs(args: TypeArgBuilder = TypeArgBuilder.create<Issue, IssueArgs>()) : TypeArgBuilder by args {
    fun number(value: Int): IssueArgs = apply { addArg("number", value) }

  }

  class IssueOrPullRequestArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueOrPullRequest, IssueOrPullRequestArgs>()) : TypeArgBuilder by args {
    fun number(value: Int): IssueOrPullRequestArgs = apply { addArg("number", value) }

  }

  class IssuesArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueConnection, IssuesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): IssuesArgs = apply { addArg("first", value) }


    fun after(value: String): IssuesArgs = apply { addArg("after", value) }


    fun last(value: Int): IssuesArgs = apply { addArg("last", value) }


    fun before(value: String): IssuesArgs = apply { addArg("before", value) }


    fun labels(value: String): IssuesArgs = apply { addArg("labels", value) }


    fun orderBy(value: IssueOrder): IssuesArgs = apply { addArg("orderBy", value) }


    fun states(value: IssueState): IssuesArgs = apply { addArg("states", value) }

  }

  class LabelArgs(args: TypeArgBuilder = TypeArgBuilder.create<Label, LabelArgs>()) : TypeArgBuilder by args {
    fun name(value: String): LabelArgs = apply { addArg("name", value) }

  }

  class LabelsArgs(args: TypeArgBuilder = TypeArgBuilder.create<LabelConnection, LabelsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): LabelsArgs = apply { addArg("first", value) }


    fun after(value: String): LabelsArgs = apply { addArg("after", value) }


    fun last(value: Int): LabelsArgs = apply { addArg("last", value) }


    fun before(value: String): LabelsArgs = apply { addArg("before", value) }

  }

  class LanguagesArgs(args: TypeArgBuilder = TypeArgBuilder.create<LanguageConnection, LanguagesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): LanguagesArgs = apply { addArg("first", value) }


    fun after(value: String): LanguagesArgs = apply { addArg("after", value) }


    fun last(value: Int): LanguagesArgs = apply { addArg("last", value) }


    fun before(value: String): LanguagesArgs = apply { addArg("before", value) }


    fun orderBy(value: LanguageOrder): LanguagesArgs = apply { addArg("orderBy", value) }

  }

  class MentionableUsersArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, MentionableUsersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): MentionableUsersArgs = apply { addArg("first", value) }


    fun after(value: String): MentionableUsersArgs = apply { addArg("after", value) }


    fun last(value: Int): MentionableUsersArgs = apply { addArg("last", value) }


    fun before(value: String): MentionableUsersArgs = apply { addArg("before", value) }

  }

  class MilestoneArgs(args: TypeArgBuilder = TypeArgBuilder.create<Milestone, MilestoneArgs>()) : TypeArgBuilder by args {
    fun number(value: Int): MilestoneArgs = apply { addArg("number", value) }

  }

  class MilestonesArgs(args: TypeArgBuilder = TypeArgBuilder.create<MilestoneConnection, MilestonesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): MilestonesArgs = apply { addArg("first", value) }


    fun after(value: String): MilestonesArgs = apply { addArg("after", value) }


    fun last(value: Int): MilestonesArgs = apply { addArg("last", value) }


    fun before(value: String): MilestonesArgs = apply { addArg("before", value) }

  }

  class ObjectValArgs(args: TypeArgBuilder = TypeArgBuilder.create<GitObject, ObjectValArgs>()) : TypeArgBuilder by args {
    fun oid(value: GitObjectID): ObjectValArgs = apply { addArg("oid", value) }


    fun expression(value: String): ObjectValArgs = apply { addArg("expression", value) }

  }

  class ProtectedBranchesArgs(args: TypeArgBuilder = TypeArgBuilder.create<ProtectedBranchConnection, ProtectedBranchesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ProtectedBranchesArgs = apply { addArg("first", value) }


    fun after(value: String): ProtectedBranchesArgs = apply { addArg("after", value) }


    fun last(value: Int): ProtectedBranchesArgs = apply { addArg("last", value) }


    fun before(value: String): ProtectedBranchesArgs = apply { addArg("before", value) }

  }

  class PullRequestArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequest, PullRequestArgs>()) : TypeArgBuilder by args {
    fun number(value: Int): PullRequestArgs = apply { addArg("number", value) }

  }

  class PullRequestsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestConnection, PullRequestsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): PullRequestsArgs = apply { addArg("first", value) }


    fun after(value: String): PullRequestsArgs = apply { addArg("after", value) }


    fun last(value: Int): PullRequestsArgs = apply { addArg("last", value) }


    fun before(value: String): PullRequestsArgs = apply { addArg("before", value) }


    fun states(value: PullRequestState): PullRequestsArgs = apply { addArg("states", value) }


    fun labels(value: String): PullRequestsArgs = apply { addArg("labels", value) }


    fun headRefName(value: String): PullRequestsArgs = apply { addArg("headRefName", value) }


    fun baseRefName(value: String): PullRequestsArgs = apply { addArg("baseRefName", value) }


    fun orderBy(value: IssueOrder): PullRequestsArgs = apply { addArg("orderBy", value) }

  }

  class RefArgs(args: TypeArgBuilder = TypeArgBuilder.create<Ref, RefArgs>()) : TypeArgBuilder by args {
    fun qualifiedName(value: String): RefArgs = apply { addArg("qualifiedName", value) }

  }

  class RefsArgs(args: TypeArgBuilder = TypeArgBuilder.create<RefConnection, RefsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): RefsArgs = apply { addArg("first", value) }


    fun after(value: String): RefsArgs = apply { addArg("after", value) }


    fun last(value: Int): RefsArgs = apply { addArg("last", value) }


    fun before(value: String): RefsArgs = apply { addArg("before", value) }


    fun refPrefix(value: String): RefsArgs = apply { addArg("refPrefix", value) }


    fun direction(value: OrderDirection): RefsArgs = apply { addArg("direction", value) }

  }

  class ReleasesArgs(args: TypeArgBuilder = TypeArgBuilder.create<ReleaseConnection, ReleasesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ReleasesArgs = apply { addArg("first", value) }


    fun after(value: String): ReleasesArgs = apply { addArg("after", value) }


    fun last(value: Int): ReleasesArgs = apply { addArg("last", value) }


    fun before(value: String): ReleasesArgs = apply { addArg("before", value) }

  }

  class RepositoryTopicsArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryTopicConnection, RepositoryTopicsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): RepositoryTopicsArgs = apply { addArg("first", value) }


    fun after(value: String): RepositoryTopicsArgs = apply { addArg("after", value) }


    fun last(value: Int): RepositoryTopicsArgs = apply { addArg("last", value) }


    fun before(value: String): RepositoryTopicsArgs = apply { addArg("before", value) }

  }

  class WatchersArgs(args: TypeArgBuilder = TypeArgBuilder.create<UserConnection, WatchersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): WatchersArgs = apply { addArg("first", value) }


    fun after(value: String): WatchersArgs = apply { addArg("after", value) }


    fun last(value: Int): WatchersArgs = apply { addArg("last", value) }


    fun before(value: String): WatchersArgs = apply { addArg("before", value) }

  }
}

enum class RepositoryAffiliation : QSchemaType {
  OWNER,

  COLLABORATOR,

  ORGANIZATION_MEMBER
}

enum class RepositoryCollaboratorAffiliation : QSchemaType {
  ALL,

  OUTSIDE
}

object RepositoryConnection : QSchemaType {
  val edges: InitStub<RepositoryEdge> by lazy { typeStub<RepositoryEdge>() }

  val nodes: InitStub<Repository> by lazy { typeStub<Repository>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }

  val totalDiskUsage: Stub<Int> by lazy { stub<Int>() }
}

object RepositoryEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Repository> by lazy { typeStub<Repository>() }
}

interface RepositoryInfo : QSchemaType {
  val createdAt: Stub<DateTime>

  val description: Stub<String>

  val descriptionHTML: Stub<HTML>

  val hasIssuesEnabled: Stub<Boolean>

  val hasWikiEnabled: Stub<Boolean>

  val homepageUrl: Stub<URI>

  val isFork: Stub<Boolean>

  val isLocked: Stub<Boolean>

  val isMirror: Stub<Boolean>

  val isPrivate: Stub<Boolean>

  val license: Stub<String>

  val lockReason: Stub<RepositoryLockReason>

  val mirrorUrl: Stub<URI>

  val name: Stub<String>

  val nameWithOwner: Stub<String>

  val owner: InitStub<RepositoryOwner>

  val pushedAt: Stub<DateTime>

  val resourcePath: Stub<URI>

  val updatedAt: Stub<DateTime>

  val url: Stub<URI>
}

object RepositoryInvitation : QSchemaType, Node {
  override val id: Stub<String> by lazy { stub<String>() }

  val invitee: InitStub<User> by lazy { typeStub<User>() }

  val inviter: InitStub<User> by lazy { typeStub<User>() }

  val repository: InitStub<RepositoryInvitationRepository> by lazy { typeStub<RepositoryInvitationRepository>() }
}

object RepositoryInvitationRepository : QSchemaType, RepositoryInfo {
  override val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val description: Stub<String> by lazy { stub<String>() }

  override val descriptionHTML: Stub<HTML> by lazy { stub<HTML>() }

  override val hasIssuesEnabled: Stub<Boolean> by lazy { stub<Boolean>() }

  override val hasWikiEnabled: Stub<Boolean> by lazy { stub<Boolean>() }

  override val homepageUrl: Stub<URI> by lazy { stub<URI>() }

  override val isFork: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isLocked: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isMirror: Stub<Boolean> by lazy { stub<Boolean>() }

  override val isPrivate: Stub<Boolean> by lazy { stub<Boolean>() }

  override val license: Stub<String> by lazy { stub<String>() }

  override val lockReason: Stub<RepositoryLockReason> by lazy { stub<RepositoryLockReason>() }

  override val mirrorUrl: Stub<URI> by lazy { stub<URI>() }

  override val name: Stub<String> by lazy { stub<String>() }

  override val nameWithOwner: Stub<String> by lazy { stub<String>() }

  override val owner: InitStub<RepositoryOwner> by lazy { typeStub<RepositoryOwner>() }

  override val pushedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  override val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

enum class RepositoryLockReason : QSchemaType {
  MOVING,

  BILLING,

  RENAME,

  MIGRATING
}

interface RepositoryNode : QSchemaType {
  val repository: InitStub<Repository>
}

data class RepositoryOrder(private val field: RepositoryOrderField,
    private val direction: OrderDirection) : QInput

enum class RepositoryOrderField : QSchemaType {
  CREATED_AT,

  UPDATED_AT,

  PUSHED_AT,

  NAME,

  STARGAZERS
}

interface RepositoryOwner : QSchemaType {
  val avatarUrl: QConfigStub<URI, BaseAvatarUrlArgs>

  val id: Stub<String>

  val login: Stub<String>

  val pinnedRepositories: QTypeConfigStub<RepositoryConnection, PinnedRepositoriesArgs>

  val repositories: QTypeConfigStub<RepositoryConnection, RepositoriesArgs>

  val repository: QTypeConfigStub<Repository, RepositoryArgs>

  val resourcePath: Stub<URI>

  val url: Stub<URI>

  class PinnedRepositoriesArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryConnection, PinnedRepositoriesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): PinnedRepositoriesArgs = apply { addArg("first", value) }


    fun after(value: String): PinnedRepositoriesArgs = apply { addArg("after", value) }


    fun last(value: Int): PinnedRepositoriesArgs = apply { addArg("last", value) }


    fun before(value: String): PinnedRepositoriesArgs = apply { addArg("before", value) }


    fun privacy(value: RepositoryPrivacy): PinnedRepositoriesArgs = apply { addArg("privacy", value) }


    fun orderBy(value: RepositoryOrder): PinnedRepositoriesArgs = apply { addArg("orderBy", value) }


    fun affiliations(value: RepositoryAffiliation): PinnedRepositoriesArgs = apply { addArg("affiliations", value) }


    fun isLocked(value: Boolean): PinnedRepositoriesArgs = apply { addArg("isLocked", value) }

  }

  class RepositoriesArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryConnection, RepositoriesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): RepositoriesArgs = apply { addArg("first", value) }


    fun after(value: String): RepositoriesArgs = apply { addArg("after", value) }


    fun last(value: Int): RepositoriesArgs = apply { addArg("last", value) }


    fun before(value: String): RepositoriesArgs = apply { addArg("before", value) }


    fun privacy(value: RepositoryPrivacy): RepositoriesArgs = apply { addArg("privacy", value) }


    fun orderBy(value: RepositoryOrder): RepositoriesArgs = apply { addArg("orderBy", value) }


    fun affiliations(value: RepositoryAffiliation): RepositoriesArgs = apply { addArg("affiliations", value) }


    fun isLocked(value: Boolean): RepositoriesArgs = apply { addArg("isLocked", value) }


    fun isFork(value: Boolean): RepositoriesArgs = apply { addArg("isFork", value) }

  }

  class RepositoryArgs(args: TypeArgBuilder = TypeArgBuilder.create<Repository, RepositoryArgs>()) : TypeArgBuilder by args {
    fun name(value: String): RepositoryArgs = apply { addArg("name", value) }

  }
}

enum class RepositoryPrivacy : QSchemaType {
  PUBLIC,

  PRIVATE
}

object RepositoryTopic : QSchemaType, UniformResourceLocatable, Node {
  override val id: Stub<String> by lazy { stub<String>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val topic: InitStub<Topic> by lazy { typeStub<Topic>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

object RepositoryTopicConnection : QSchemaType {
  val edges: InitStub<RepositoryTopicEdge> by lazy { typeStub<RepositoryTopicEdge>() }

  val nodes: InitStub<RepositoryTopic> by lazy { typeStub<RepositoryTopic>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object RepositoryTopicEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<RepositoryTopic> by lazy { typeStub<RepositoryTopic>() }
}

data class RequestReviewsInput(private val pullRequestId: String, private val userIds: String,
    private val teamIds: String) : QInput {
  private var clientMutationId: String? = null
  private var union: Boolean? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun union(model: Boolean) = apply { union = model }
}

object RequestReviewsPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val requestedReviewersEdge: InitStub<UserEdge> by lazy { typeStub<UserEdge>() }
}

object ReviewDismissalAllowance : QSchemaType, Node {
  val actor: InitStub<ReviewDismissalAllowanceActor> by lazy { typeStub<ReviewDismissalAllowanceActor>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val protectedBranch: InitStub<ProtectedBranch> by lazy { typeStub<ProtectedBranch>() }
}

object ReviewDismissalAllowanceActor : QSchemaType {
  val User: InitStub<User> by lazy { typeStub<User>() }

  val Team: InitStub<Team> by lazy { typeStub<Team>() }
}

object ReviewDismissalAllowanceConnection : QSchemaType {
  val edges: InitStub<ReviewDismissalAllowanceEdge> by lazy { typeStub<ReviewDismissalAllowanceEdge>() }

  val nodes: InitStub<ReviewDismissalAllowance> by lazy { typeStub<ReviewDismissalAllowance>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ReviewDismissalAllowanceEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ReviewDismissalAllowance> by lazy { typeStub<ReviewDismissalAllowance>() }
}

object ReviewDismissedEvent : QSchemaType, UniformResourceLocatable, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val message: Stub<String> by lazy { stub<String>() }

  val messageHtml: Stub<HTML> by lazy { stub<HTML>() }

  val previousReviewState: Stub<PullRequestReviewState> by lazy { stub<PullRequestReviewState>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val pullRequestCommit: InitStub<PullRequestCommit> by lazy { typeStub<PullRequestCommit>() }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val review: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }

  override val url: Stub<URI> by lazy { stub<URI>() }
}

object ReviewRequest : QSchemaType, Node {
  val databaseId: Stub<Int> by lazy { stub<Int>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val reviewer: InitStub<User> by lazy { typeStub<User>() }
}

object ReviewRequestConnection : QSchemaType {
  val edges: InitStub<ReviewRequestEdge> by lazy { typeStub<ReviewRequestEdge>() }

  val nodes: InitStub<ReviewRequest> by lazy { typeStub<ReviewRequest>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object ReviewRequestEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<ReviewRequest> by lazy { typeStub<ReviewRequest>() }
}

object ReviewRequestRemovedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val subject: InitStub<User> by lazy { typeStub<User>() }
}

object ReviewRequestedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val pullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val subject: InitStub<User> by lazy { typeStub<User>() }
}

object SearchResultItem : QSchemaType {
  val Issue: InitStub<Issue> by lazy { typeStub<Issue>() }

  val PullRequest: InitStub<PullRequest> by lazy { typeStub<PullRequest>() }

  val Repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val User: InitStub<User> by lazy { typeStub<User>() }

  val Organization: InitStub<Organization> by lazy { typeStub<Organization>() }
}

object SearchResultItemConnection : QSchemaType {
  val codeCount: Stub<Int> by lazy { stub<Int>() }

  val edges: InitStub<SearchResultItemEdge> by lazy { typeStub<SearchResultItemEdge>() }

  val issueCount: Stub<Int> by lazy { stub<Int>() }

  val nodes: InitStub<SearchResultItem> by lazy { typeStub<SearchResultItem>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val repositoryCount: Stub<Int> by lazy { stub<Int>() }

  val userCount: Stub<Int> by lazy { stub<Int>() }

  val wikiCount: Stub<Int> by lazy { stub<Int>() }
}

object SearchResultItemEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<SearchResultItem> by lazy { typeStub<SearchResultItem>() }
}

enum class SearchType : QSchemaType {
  ISSUE,

  REPOSITORY,

  USER
}

object SmimeSignature : QSchemaType, GitSignature {
  override val email: Stub<String> by lazy { stub<String>() }

  override val isValid: Stub<Boolean> by lazy { stub<Boolean>() }

  override val payload: Stub<String> by lazy { stub<String>() }

  override val signature: Stub<String> by lazy { stub<String>() }

  override val signer: InitStub<User> by lazy { typeStub<User>() }

  override val state: Stub<GitSignatureState> by lazy { stub<GitSignatureState>() }
}

data class StarOrder(private val field: StarOrderField,
    private val direction: OrderDirection) : QInput

enum class StarOrderField : QSchemaType {
  STARRED_AT
}

object StargazerConnection : QSchemaType {
  val edges: InitStub<StargazerEdge> by lazy { typeStub<StargazerEdge>() }

  val nodes: InitStub<User> by lazy { typeStub<User>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object StargazerEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<User> by lazy { typeStub<User>() }

  val starredAt: Stub<DateTime> by lazy { stub<DateTime>() }
}

interface Starrable : QSchemaType {
  val id: Stub<String>

  val stargazers: QTypeConfigStub<StargazerConnection, StargazersArgs>

  val viewerHasStarred: Stub<Boolean>

  class StargazersArgs(args: TypeArgBuilder = TypeArgBuilder.create<StargazerConnection, StargazersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): StargazersArgs = apply { addArg("first", value) }


    fun after(value: String): StargazersArgs = apply { addArg("after", value) }


    fun last(value: Int): StargazersArgs = apply { addArg("last", value) }


    fun before(value: String): StargazersArgs = apply { addArg("before", value) }


    fun orderBy(value: StarOrder): StargazersArgs = apply { addArg("orderBy", value) }

  }
}

object StarredRepositoryConnection : QSchemaType {
  val edges: InitStub<StarredRepositoryEdge> by lazy { typeStub<StarredRepositoryEdge>() }

  val nodes: InitStub<Repository> by lazy { typeStub<Repository>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object StarredRepositoryEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Repository> by lazy { typeStub<Repository>() }

  val starredAt: Stub<DateTime> by lazy { stub<DateTime>() }
}

object Status : QSchemaType, Node {
  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val context: QTypeConfigStub<StatusContext, ContextArgs> by lazy { typeConfigStub<StatusContext, ContextArgs>(ContextArgs()) }

  val contexts: InitStub<StatusContext> by lazy { typeStub<StatusContext>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val state: Stub<StatusState> by lazy { stub<StatusState>() }

  class ContextArgs(args: TypeArgBuilder = TypeArgBuilder.create<StatusContext, ContextArgs>()) : TypeArgBuilder by args {
    fun name(value: String): ContextArgs = apply { addArg("name", value) }

  }
}

object StatusContext : QSchemaType, Node {
  val commit: InitStub<Commit> by lazy { typeStub<Commit>() }

  val context: Stub<String> by lazy { stub<String>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val creator: InitStub<Actor> by lazy { typeStub<Actor>() }

  val description: Stub<String> by lazy { stub<String>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val state: Stub<StatusState> by lazy { stub<StatusState>() }

  val targetUrl: Stub<URI> by lazy { stub<URI>() }
}

enum class StatusState : QSchemaType {
  EXPECTED,

  ERROR,

  FAILURE,

  PENDING,

  SUCCESS
}

data class SubmitPullRequestReviewInput(private val pullRequestReviewId: String,
    private val event: PullRequestReviewEvent) : QInput {
  private var clientMutationId: String? = null
  private var body: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun body(model: String) = apply { body = model }
}

object SubmitPullRequestReviewPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }
}

interface Subscribable : QSchemaType {
  val viewerCanSubscribe: Stub<Boolean>

  val viewerSubscription: Stub<SubscriptionState>
}

object SubscribedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val subscribable: InitStub<Subscribable> by lazy { typeStub<Subscribable>() }
}

enum class SubscriptionState : QSchemaType {
  UNSUBSCRIBED,

  SUBSCRIBED,

  IGNORED
}

object SuggestedReviewer : QSchemaType {
  val isAuthor: Stub<Boolean> by lazy { stub<Boolean>() }

  val isCommenter: Stub<Boolean> by lazy { stub<Boolean>() }

  val reviewer: InitStub<User> by lazy { typeStub<User>() }
}

object Tag : QSchemaType, GitObject, Node {
  override val abbreviatedOid: Stub<String> by lazy { stub<String>() }

  override val commitResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val commitUrl: Stub<URI> by lazy { stub<URI>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val message: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  override val oid: Stub<GitObjectID> by lazy { stub<GitObjectID>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val tagger: InitStub<GitActor> by lazy { typeStub<GitActor>() }

  val target: InitStub<GitObject> by lazy { typeStub<GitObject>() }
}

object Team : QSchemaType, Node {
  val description: Stub<String> by lazy { stub<String>() }

  val editTeamResourcePath: Stub<URI> by lazy { stub<URI>() }

  val editTeamUrl: Stub<URI> by lazy { stub<URI>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val invitations: QTypeConfigStub<OrganizationInvitationConnection, InvitationsArgs> by lazy { typeConfigStub<OrganizationInvitationConnection, InvitationsArgs>(InvitationsArgs()) }

  val name: Stub<String> by lazy { stub<String>() }

  val organization: InitStub<Organization> by lazy { typeStub<Organization>() }

  val privacy: Stub<TeamPrivacy> by lazy { stub<TeamPrivacy>() }

  val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val slug: Stub<String> by lazy { stub<String>() }

  val url: Stub<URI> by lazy { stub<URI>() }

  class InvitationsArgs(args: TypeArgBuilder = TypeArgBuilder.create<OrganizationInvitationConnection, InvitationsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): InvitationsArgs = apply { addArg("first", value) }


    fun after(value: String): InvitationsArgs = apply { addArg("after", value) }


    fun last(value: Int): InvitationsArgs = apply { addArg("last", value) }


    fun before(value: String): InvitationsArgs = apply { addArg("before", value) }

  }
}

object TeamConnection : QSchemaType {
  val edges: InitStub<TeamEdge> by lazy { typeStub<TeamEdge>() }

  val nodes: InitStub<Team> by lazy { typeStub<Team>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object TeamEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<Team> by lazy { typeStub<Team>() }
}

data class TeamOrder(private val field: TeamOrderField,
    private val direction: OrderDirection) : QInput

enum class TeamOrderField : QSchemaType {
  NAME
}

enum class TeamPrivacy : QSchemaType {
  SECRET,

  VISIBLE
}

enum class TeamRole : QSchemaType {
  ADMIN,

  MEMBER
}

object Topic : QSchemaType, Node {
  override val id: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val relatedTopics: InitStub<Topic> by lazy { typeStub<Topic>() }
}

enum class TopicSuggestionDeclineReason : QSchemaType {
  NOT_RELEVANT,

  TOO_SPECIFIC,

  PERSONAL_PREFERENCE,

  TOO_GENERAL
}

object Tree : QSchemaType, GitObject, Node {
  override val abbreviatedOid: Stub<String> by lazy { stub<String>() }

  override val commitResourcePath: Stub<URI> by lazy { stub<URI>() }

  override val commitUrl: Stub<URI> by lazy { stub<URI>() }

  val entries: InitStub<TreeEntry> by lazy { typeStub<TreeEntry>() }

  override val id: Stub<String> by lazy { stub<String>() }

  override val oid: Stub<GitObjectID> by lazy { stub<GitObjectID>() }

  override val repository: InitStub<Repository> by lazy { typeStub<Repository>() }
}

object TreeEntry : QSchemaType {
  val mode: Stub<Int> by lazy { stub<Int>() }

  val name: Stub<String> by lazy { stub<String>() }

  val objectVal: InitStub<GitObject> by lazy { typeStub<GitObject>() }

  val oid: Stub<GitObjectID> by lazy { stub<GitObjectID>() }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }

  val type: Stub<String> by lazy { stub<String>() }
}

object URI : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

object UnassignedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val assignable: InitStub<Assignable> by lazy { typeStub<Assignable>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val user: InitStub<User> by lazy { typeStub<User>() }
}

interface UniformResourceLocatable : QSchemaType {
  val resourcePath: Stub<URI>

  val url: Stub<URI>
}

object UnknownSignature : QSchemaType, GitSignature {
  override val email: Stub<String> by lazy { stub<String>() }

  override val isValid: Stub<Boolean> by lazy { stub<Boolean>() }

  override val payload: Stub<String> by lazy { stub<String>() }

  override val signature: Stub<String> by lazy { stub<String>() }

  override val signer: InitStub<User> by lazy { typeStub<User>() }

  override val state: Stub<GitSignatureState> by lazy { stub<GitSignatureState>() }
}

object UnlabeledEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val label: InitStub<Label> by lazy { typeStub<Label>() }

  val labelable: InitStub<Labelable> by lazy { typeStub<Labelable>() }
}

object UnlockedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val lockable: InitStub<Lockable> by lazy { typeStub<Lockable>() }
}

object UnsubscribedEvent : QSchemaType, Node {
  val actor: InitStub<Actor> by lazy { typeStub<Actor>() }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val id: Stub<String> by lazy { stub<String>() }

  val subscribable: InitStub<Subscribable> by lazy { typeStub<Subscribable>() }
}

interface Updatable : QSchemaType {
  val viewerCanUpdate: Stub<Boolean>
}

interface UpdatableComment : QSchemaType {
  val viewerCannotUpdateReasons: Stub<CommentCannotUpdateReason>
}

data class UpdateProjectCardInput(private val projectCardId: String,
    private val note: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdateProjectCardPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val projectCard: InitStub<ProjectCard> by lazy { typeStub<ProjectCard>() }
}

data class UpdateProjectColumnInput(private val projectColumnId: String,
    private val name: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdateProjectColumnPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val projectColumn: InitStub<ProjectColumn> by lazy { typeStub<ProjectColumn>() }
}

data class UpdateProjectInput(private val projectId: String, private val name: String) : QInput {
  private var clientMutationId: String? = null
  private var body: String? = null
  private var state: ProjectState? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }

  fun body(model: String) = apply { body = model }

  fun state(model: ProjectState) = apply { state = model }
}

object UpdateProjectPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val project: InitStub<Project> by lazy { typeStub<Project>() }
}

data class UpdatePullRequestReviewCommentInput(private val pullRequestReviewCommentId: String,
    private val body: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdatePullRequestReviewCommentPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReviewComment: InitStub<PullRequestReviewComment> by lazy { typeStub<PullRequestReviewComment>() }
}

data class UpdatePullRequestReviewInput(private val pullRequestReviewId: String,
    private val body: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdatePullRequestReviewPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val pullRequestReview: InitStub<PullRequestReview> by lazy { typeStub<PullRequestReview>() }
}

data class UpdateSubscriptionInput(private val subscribableId: String,
    private val state: SubscriptionState) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdateSubscriptionPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val subscribable: InitStub<Subscribable> by lazy { typeStub<Subscribable>() }
}

data class UpdateTopicsInput(private val repositoryId: String,
    private val topicNames: String) : QInput {
  private var clientMutationId: String? = null
  fun clientMutationId(model: String) = apply { clientMutationId = model }
}

object UpdateTopicsPayload : QSchemaType {
  val clientMutationId: Stub<String> by lazy { stub<String>() }

  val invalidTopicNames: Stub<String> by lazy { stub<String>() }

  val repository: InitStub<Repository> by lazy { typeStub<Repository>() }
}

object User : QSchemaType, UniformResourceLocatable, RepositoryOwner, Actor, Node {
  override val avatarUrl: QConfigStub<URI, AvatarUrlArgs> by lazy { configStub<URI, AvatarUrlArgs>(AvatarUrlArgs()) }

  val bio: Stub<String> by lazy { stub<String>() }

  val bioHTML: Stub<HTML> by lazy { stub<HTML>() }

  val company: Stub<String> by lazy { stub<String>() }

  val companyHTML: Stub<HTML> by lazy { stub<HTML>() }

  val contributedRepositories: QTypeConfigStub<RepositoryConnection, ContributedRepositoriesArgs> by lazy { typeConfigStub<RepositoryConnection, ContributedRepositoriesArgs>(ContributedRepositoriesArgs()) }

  val createdAt: Stub<DateTime> by lazy { stub<DateTime>() }

  val databaseId: Stub<Int> by lazy { stub<Int>() }

  val email: Stub<String> by lazy { stub<String>() }

  val followers: QTypeConfigStub<FollowerConnection, FollowersArgs> by lazy { typeConfigStub<FollowerConnection, FollowersArgs>(FollowersArgs()) }

  val following: QTypeConfigStub<FollowingConnection, FollowingArgs> by lazy { typeConfigStub<FollowingConnection, FollowingArgs>(FollowingArgs()) }

  val gist: QTypeConfigStub<Gist, GistArgs> by lazy { typeConfigStub<Gist, GistArgs>(GistArgs()) }

  val gists: QTypeConfigStub<GistConnection, GistsArgs> by lazy { typeConfigStub<GistConnection, GistsArgs>(GistsArgs()) }

  override val id: Stub<String> by lazy { stub<String>() }

  val isBountyHunter: Stub<Boolean> by lazy { stub<Boolean>() }

  val isCampusExpert: Stub<Boolean> by lazy { stub<Boolean>() }

  val isDeveloperProgramMember: Stub<Boolean> by lazy { stub<Boolean>() }

  val isEmployee: Stub<Boolean> by lazy { stub<Boolean>() }

  val isHireable: Stub<Boolean> by lazy { stub<Boolean>() }

  val isInvoiced: Stub<Boolean> by lazy { stub<Boolean>() }

  val isSiteAdmin: Stub<Boolean> by lazy { stub<Boolean>() }

  val isViewer: Stub<Boolean> by lazy { stub<Boolean>() }

  val issues: QTypeConfigStub<IssueConnection, IssuesArgs> by lazy { typeConfigStub<IssueConnection, IssuesArgs>(IssuesArgs()) }

  val location: Stub<String> by lazy { stub<String>() }

  override val login: Stub<String> by lazy { stub<String>() }

  val name: Stub<String> by lazy { stub<String>() }

  val organization: QTypeConfigStub<Organization, OrganizationArgs> by lazy { typeConfigStub<Organization, OrganizationArgs>(OrganizationArgs()) }

  val organizations: QTypeConfigStub<OrganizationConnection, OrganizationsArgs> by lazy { typeConfigStub<OrganizationConnection, OrganizationsArgs>(OrganizationsArgs()) }

  override val pinnedRepositories: QTypeConfigStub<RepositoryConnection, RepositoryOwner.PinnedRepositoriesArgs> by lazy { typeConfigStub<RepositoryConnection, RepositoryOwner.PinnedRepositoriesArgs>(RepositoryOwner.PinnedRepositoriesArgs()) }

  val pullRequests: QTypeConfigStub<PullRequestConnection, PullRequestsArgs> by lazy { typeConfigStub<PullRequestConnection, PullRequestsArgs>(PullRequestsArgs()) }

  override val repositories: QTypeConfigStub<RepositoryConnection, RepositoryOwner.RepositoriesArgs> by lazy { typeConfigStub<RepositoryConnection, RepositoryOwner.RepositoriesArgs>(RepositoryOwner.RepositoriesArgs()) }

  override val repository: QTypeConfigStub<Repository, RepositoryOwner.RepositoryArgs> by lazy { typeConfigStub<Repository, RepositoryOwner.RepositoryArgs>(RepositoryOwner.RepositoryArgs()) }

  override val resourcePath: Stub<URI> by lazy { stub<URI>() }

  val starredRepositories: QTypeConfigStub<StarredRepositoryConnection, StarredRepositoriesArgs> by lazy { typeConfigStub<StarredRepositoryConnection, StarredRepositoriesArgs>(StarredRepositoriesArgs()) }

  val updatedAt: Stub<DateTime> by lazy { stub<DateTime>() }

  override val url: Stub<URI> by lazy { stub<URI>() }

  val viewerCanFollow: Stub<Boolean> by lazy { stub<Boolean>() }

  val viewerIsFollowing: Stub<Boolean> by lazy { stub<Boolean>() }

  val watching: QTypeConfigStub<RepositoryConnection, WatchingArgs> by lazy { typeConfigStub<RepositoryConnection, WatchingArgs>(WatchingArgs()) }

  val websiteUrl: Stub<URI> by lazy { stub<URI>() }

  class AvatarUrlArgs(args: ArgBuilder = ArgBuilder.create<URI, AvatarUrlArgs>()) : BaseAvatarUrlArgs(args) {
    fun size(value: Int): AvatarUrlArgs = apply { addArg("size", value) }

  }

  class ContributedRepositoriesArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryConnection, ContributedRepositoriesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): ContributedRepositoriesArgs = apply { addArg("first", value) }


    fun after(value: String): ContributedRepositoriesArgs = apply { addArg("after", value) }


    fun last(value: Int): ContributedRepositoriesArgs = apply { addArg("last", value) }


    fun before(value: String): ContributedRepositoriesArgs = apply { addArg("before", value) }


    fun privacy(value: RepositoryPrivacy): ContributedRepositoriesArgs = apply { addArg("privacy", value) }


    fun orderBy(value: RepositoryOrder): ContributedRepositoriesArgs = apply { addArg("orderBy", value) }


    fun affiliations(value: RepositoryAffiliation): ContributedRepositoriesArgs = apply { addArg("affiliations", value) }


    fun isLocked(value: Boolean): ContributedRepositoriesArgs = apply { addArg("isLocked", value) }

  }

  class FollowersArgs(args: TypeArgBuilder = TypeArgBuilder.create<FollowerConnection, FollowersArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): FollowersArgs = apply { addArg("first", value) }


    fun after(value: String): FollowersArgs = apply { addArg("after", value) }


    fun last(value: Int): FollowersArgs = apply { addArg("last", value) }


    fun before(value: String): FollowersArgs = apply { addArg("before", value) }

  }

  class FollowingArgs(args: TypeArgBuilder = TypeArgBuilder.create<FollowingConnection, FollowingArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): FollowingArgs = apply { addArg("first", value) }


    fun after(value: String): FollowingArgs = apply { addArg("after", value) }


    fun last(value: Int): FollowingArgs = apply { addArg("last", value) }


    fun before(value: String): FollowingArgs = apply { addArg("before", value) }

  }

  class GistArgs(args: TypeArgBuilder = TypeArgBuilder.create<Gist, GistArgs>()) : TypeArgBuilder by args {
    fun name(value: String): GistArgs = apply { addArg("name", value) }

  }

  class GistsArgs(args: TypeArgBuilder = TypeArgBuilder.create<GistConnection, GistsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): GistsArgs = apply { addArg("first", value) }


    fun after(value: String): GistsArgs = apply { addArg("after", value) }


    fun last(value: Int): GistsArgs = apply { addArg("last", value) }


    fun before(value: String): GistsArgs = apply { addArg("before", value) }


    fun privacy(value: GistPrivacy): GistsArgs = apply { addArg("privacy", value) }

  }

  class IssuesArgs(args: TypeArgBuilder = TypeArgBuilder.create<IssueConnection, IssuesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): IssuesArgs = apply { addArg("first", value) }


    fun after(value: String): IssuesArgs = apply { addArg("after", value) }


    fun last(value: Int): IssuesArgs = apply { addArg("last", value) }


    fun before(value: String): IssuesArgs = apply { addArg("before", value) }


    fun labels(value: String): IssuesArgs = apply { addArg("labels", value) }


    fun orderBy(value: IssueOrder): IssuesArgs = apply { addArg("orderBy", value) }


    fun states(value: IssueState): IssuesArgs = apply { addArg("states", value) }

  }

  class OrganizationArgs(args: TypeArgBuilder = TypeArgBuilder.create<Organization, OrganizationArgs>()) : TypeArgBuilder by args {
    fun login(value: String): OrganizationArgs = apply { addArg("login", value) }

  }

  class OrganizationsArgs(args: TypeArgBuilder = TypeArgBuilder.create<OrganizationConnection, OrganizationsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): OrganizationsArgs = apply { addArg("first", value) }


    fun after(value: String): OrganizationsArgs = apply { addArg("after", value) }


    fun last(value: Int): OrganizationsArgs = apply { addArg("last", value) }


    fun before(value: String): OrganizationsArgs = apply { addArg("before", value) }

  }

  class PullRequestsArgs(args: TypeArgBuilder = TypeArgBuilder.create<PullRequestConnection, PullRequestsArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): PullRequestsArgs = apply { addArg("first", value) }


    fun after(value: String): PullRequestsArgs = apply { addArg("after", value) }


    fun last(value: Int): PullRequestsArgs = apply { addArg("last", value) }


    fun before(value: String): PullRequestsArgs = apply { addArg("before", value) }


    fun states(value: PullRequestState): PullRequestsArgs = apply { addArg("states", value) }


    fun labels(value: String): PullRequestsArgs = apply { addArg("labels", value) }


    fun headRefName(value: String): PullRequestsArgs = apply { addArg("headRefName", value) }


    fun baseRefName(value: String): PullRequestsArgs = apply { addArg("baseRefName", value) }


    fun orderBy(value: IssueOrder): PullRequestsArgs = apply { addArg("orderBy", value) }

  }

  class StarredRepositoriesArgs(args: TypeArgBuilder = TypeArgBuilder.create<StarredRepositoryConnection, StarredRepositoriesArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): StarredRepositoriesArgs = apply { addArg("first", value) }


    fun after(value: String): StarredRepositoriesArgs = apply { addArg("after", value) }


    fun last(value: Int): StarredRepositoriesArgs = apply { addArg("last", value) }


    fun before(value: String): StarredRepositoriesArgs = apply { addArg("before", value) }


    fun ownedByViewer(value: Boolean): StarredRepositoriesArgs = apply { addArg("ownedByViewer", value) }


    fun orderBy(value: StarOrder): StarredRepositoriesArgs = apply { addArg("orderBy", value) }

  }

  class WatchingArgs(args: TypeArgBuilder = TypeArgBuilder.create<RepositoryConnection, WatchingArgs>()) : TypeArgBuilder by args {
    fun first(value: Int): WatchingArgs = apply { addArg("first", value) }


    fun after(value: String): WatchingArgs = apply { addArg("after", value) }


    fun last(value: Int): WatchingArgs = apply { addArg("last", value) }


    fun before(value: String): WatchingArgs = apply { addArg("before", value) }


    fun privacy(value: RepositoryPrivacy): WatchingArgs = apply { addArg("privacy", value) }


    fun orderBy(value: RepositoryOrder): WatchingArgs = apply { addArg("orderBy", value) }


    fun affiliations(value: RepositoryAffiliation): WatchingArgs = apply { addArg("affiliations", value) }


    fun isLocked(value: Boolean): WatchingArgs = apply { addArg("isLocked", value) }

  }
}

object UserConnection : QSchemaType {
  val edges: InitStub<UserEdge> by lazy { typeStub<UserEdge>() }

  val nodes: InitStub<User> by lazy { typeStub<User>() }

  val pageInfo: InitStub<PageInfo> by lazy { typeStub<PageInfo>() }

  val totalCount: Stub<Int> by lazy { stub<Int>() }
}

object UserEdge : QSchemaType {
  val cursor: Stub<String> by lazy { stub<String>() }

  val node: InitStub<User> by lazy { typeStub<User>() }
}

object X509Certificate : QSchemaType {
  val value: Stub<String> by lazy { stub<String>() }
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node
{
  int item;
  struct Node *left;
  struct Node *right;
};
struct Node *root = NULL;

void inorder(struct Node *root)
{
  if (root == NULL)
    return;
  inorder(root->left);
  printf("%d ->", root->item);
  inorder(root->right);
}

void preorder(struct Node *root)
{
  if (root == NULL)
    return;
  printf("%d ->", root->item);
  preorder(root->left);
  preorder(root->right);
}

void postorder(struct Node *root)
{
  if (root == NULL)
    return;
  postorder(root->left);
  postorder(root->right);
  printf("%d ->", root->item);
}

struct Node *initNode(int value)
{
  struct Node *newNode = malloc(sizeof(struct Node));
  newNode->item = value;
  newNode->left = NULL;
  newNode->right = NULL;

  return newNode;
}

struct Node *insert(struct Node *root, int item)
{
  if (root == NULL)
    return initNode(item);

  if (root->item < item)
    root->right = insert(root->right, item);

  else if (root->item > item)
    root->left = insert(root->left, item);

  return root;
}

int search(struct Node *node, int key)
{
  if (node == NULL)
    return 0;

  if (node->item == key)
    return 1;

  int res1 = search(node->left, key);
  if (res1)
    return 1;

  int res2 = search(node->right, key);

  return res2;
}

void storeInorder(struct Node *node, int inorder[], int *index_ptr)
{
  if (node == NULL)
    return;

  storeInorder(node->left, inorder, index_ptr);

  inorder[*index_ptr] = node->item;
  (*index_ptr)++;

  storeInorder(node->right, inorder, index_ptr);
}

int countNodes(struct Node *root)
{
  if (root == NULL)
    return 0;
  return countNodes(root->left) + countNodes(root->right) + 1;
}

int compare(const void *a, const void *b)
{
  return (*(int *)a - *(int *)b);
}

void arrayToBST(int *arr, struct Node *root, int *index_ptr)
{
  if (root == NULL)
    return;

  arrayToBST(arr, root->left, index_ptr);

  root->item = arr[*index_ptr];
  (*index_ptr)++;

  arrayToBST(arr, root->right, index_ptr);
}

void binaryTreeToBST(struct Node *root)
{
  if (root == NULL)
    return;

  int n = countNodes(root);

  int *arr = (int *)malloc(n * sizeof(int));
  int i = 0;
  storeInorder(root, arr, &i);

  qsort(arr, n, sizeof(arr[0]), compare);

  i = 0;
  arrayToBST(arr, root, &i);

  free(arr);
}

int smallestElement(struct Node *temp)
{
  if (root == NULL)
  {
    printf("Tree is empty\n");
    return 0;
  }
  else
  {
    int leftMin, rightMin;
    int min = temp->item;

    if (temp->left != NULL)
    {
      leftMin = smallestElement(temp->left);
      min = (min > leftMin) ? leftMin : min;
    }

    if (temp->right != NULL)
    {
      rightMin = smallestElement(temp->right);
      min = (min > rightMin) ? rightMin : min;
    }
    return min;
  }
}
struct Node *sortedArrayToBST(int arr[], int start, int end)
{
  if (start > end)
    return NULL;

  int mid = (start + end) / 2;
  struct Node *root = initNode(arr[mid]);

  root->left = sortedArrayToBST(arr, start, mid - 1);

  root->right = sortedArrayToBST(arr, mid + 1, end);

  return root;
}
struct Node *Delete(struct Node *node, int item)
{
  struct Node *temp;
  if (node == NULL)
  {
    printf("Element Not Found");
  }
  else if (item < node->item)
  {
    node->left = Delete(node->left, item);
  }
  else if (item > node->item)
  {
    node->right = Delete(node->right, item);
  }
  else
  {
    if (node->right && node->left)
    {
      temp = smallestElement(node->right);
      node->item = temp->item;

      node->right = Delete(node->right, temp->item);
    }
    else
    {
      temp = node;
      if (node->left == NULL)
        node = node->right;
      else if (node->right == NULL)
        node = node->left;
      free(temp);
    }
  }
  return node;
}

int main()
{
  int n;

  while (n)
  {
    printf("\n1 - insert in binary tree\n");
    printf("9 - read from file \n");
    printf("2 - display inorder\n");
    printf("3 - display postorder\n");
    printf("4 - display preorder\n");
    printf("5 - search for element\n");
    printf("6 - transform in bst\n");
    printf("7 - delete item\n");
    printf("0 - exit\n");

    scanf("%d", &n);
    printf("\e[1;1H\e[2J");
    switch (n)
    {
    case 1:
    {
      int item;
      scanf("%d", &item);
      if (root == NULL)
      {
        root = initNode(item);
        break;
      }
      insert(root, item);
    }
    break;
    case 2:
    {
      inorder(root);
    };
    break;
    case 3:
    {
      postorder(root);
    };
    break;
    case 4:
    {
      preorder(root);
    };
    break;
    case 5:
    {
      int item;
      scanf("%d", &item);
      if (!search(root, item))
      {
        printf("Doesn't exist");
        break;
      }
      printf("Exists");
    };
    break;
    case 6:
    {
      binaryTreeToBST(root);
    };
    break;
    case 7:
    {
      int item;
      printf("node to delete:");
      scanf("%d", &item);

      Delete(root, item);
    };
    break;
    case 8:
    {
      int *arr = (int *)malloc(n * sizeof(int));
      int i = 0;
      int n = countNodes(root);
      storeInorder(root, arr, &i);
      sortedArrayToBST(arr, 0, n - 1);
    };
    break;
    case 9:
    {
      char line[150], tempLine[20], saveLine[150];
      char fileName[20], fileName2[20];
      int end, start, value;
      char num[20];

      printf("Enter the name for the file to be opened ('.txt' must be included): ");
      scanf("\n%[^\n]", fileName);
      FILE *fpointer = fopen(fileName, "r");
      fgets(line, 150, fpointer);
      fclose(fpointer);
      if (strlen(line) == 0)
      {
        break;
      }
      for (int i = 0; i < strlen(line); i++)
      {
        if (line[i] == ' ')
        {
          int subLen;
          subLen = end - start + 1;
          memset(num, '\0', sizeof(num));
          for (int k = 0; k < subLen; k++)
          {
            num[k] = line[start + k];
          }
          value = atoi(num);
          if (root == NULL)
          {
            root = initNode(value);
            continue;
          }
          insert(root, value);
        }
        else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
        {
          if (i == strlen(line) - 1)
          {
            end = strlen(line) - 1;
            if (line[i - 1] == ' ')
            {
              start = i;
            }
            int subLen;
            subLen = end - start + 1;
            memset(num, '\0', sizeof(num));
            for (int k = 0; k < subLen; k++)
            {
              num[k] = line[start + k];
            }
            value = atoi(num);
            if (root == NULL)
            {
              root = initNode(value);
              continue;
            }
            insert(root, value);
            memset(num, '\0', sizeof(num));
          }
          else
          {
            if (i == 0 || line[i - 1] == ' ')
            {
              start = i;
              end = i;
            }
            if (line[i + 1] == ' ')
            {
              end = i;
            }
          }
        }
        else
        {
          printf("\nPlease enter a valid input!");
          break;
        }
      }
    }
    break;
    default:
      break;
    }
  }
}